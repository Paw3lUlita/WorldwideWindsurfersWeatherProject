package pl.ulita.worldwidewindsurfersweatherproject.weather.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import pl.ulita.worldwidewindsurfersweatherproject.location.dto.LocationResponseDTO;
import pl.ulita.worldwidewindsurfersweatherproject.location.model.Location;
import pl.ulita.worldwidewindsurfersweatherproject.location.repository.LocationRepository;
import pl.ulita.worldwidewindsurfersweatherproject.weather.dto.WeatherDataDTO;
import pl.ulita.worldwidewindsurfersweatherproject.weather.httpclient.RestTemplateHttpClient;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Data
@AllArgsConstructor
public class WeatherRestTemplateService implements WeatherService {
    private final RestTemplateHttpClient httpClient;
    private final LocationRepository locationRepository;

    private List<Location> getForecastForAllLocations() {
        List<Location> returnList = locationRepository.findAll();
        returnList.forEach(location ->
                location.setForecast(httpClient.getForecastByLocation(location)));
        return returnList;
    }

    private List<Location> filterForecastByDate(LocalDate date, List<Location> locations) {
        List<Location> resulList = List.copyOf(locations);
        resulList.forEach(location -> location.getForecast().setData(
                location.getForecast().getData().stream()
                        .filter(weatherDataDTO -> weatherDataDTO.getValidDate().equals(date))
                        .toList())
        );
        return resulList;
    }

    private double computeConditions(WeatherDataDTO data) {
        if (!(data.getWindSpeed() >= 5 && data.getWindSpeed() <= 18)) {
            return 0;
        }
        if (!(data.getTemperature() >= 5 && data.getTemperature() <= 35)) {
            return 0;
        }

        return data.getWindSpeed() * 3 + data.getTemperature();
    }

    public LocationResponseDTO findLocationWithBestConditions(LocalDate date) {
        Map<Location, Double> conditionsByLocation = new HashMap<>();
        List<Location> locations = filterForecastByDate(date, getForecastForAllLocations());

        locations.forEach(location -> {
            conditionsByLocation.put(location, computeConditions(location.getForecast().getData().get(0)));
        });

        double bestConditions = Collections.max(conditionsByLocation.values());
        Location bestLocation = new Location();

        for (Map.Entry<Location, Double> entry : conditionsByLocation.entrySet()) {
            if (entry.getValue().equals(bestConditions)) {
                bestLocation = entry.getKey();
            }
        }

        return new LocationResponseDTO(
                bestLocation.getName(),
                bestLocation.getCountry(),
                bestLocation.getForecast().getData().get(0).getTemperature(),
                bestLocation.getForecast().getData().get(0).getWindSpeed());
    }
}
