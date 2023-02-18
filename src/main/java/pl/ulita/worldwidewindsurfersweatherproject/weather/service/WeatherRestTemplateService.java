package pl.ulita.worldwidewindsurfersweatherproject.weather.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.ulita.worldwidewindsurfersweatherproject.location.model.Location;
import pl.ulita.worldwidewindsurfersweatherproject.location.repository.LocationRepository;
import pl.ulita.worldwidewindsurfersweatherproject.weather.model.WeatherForecastDTO;

import java.time.LocalDate;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class WeatherRestTemplateService implements WeatherUseCase {
    private final String API_KEY = "de91367822fd435b9347e0dde4d3c8ab";
    private final RestTemplate restTemplate;
    private final LocationRepository locationRepository;

    public WeatherForecastDTO getForecastByLocation(Location location) {
        return restTemplate.getForObject(
                "https://api.weatherbit.io/v2.0/forecast/daily?lat={latitude}&lon={longtitude}&key={API_KEY}",
                WeatherForecastDTO.class, location.getLatitude(), location.getLongtitude(), API_KEY);
    }

    public List<Location> getForecastForAllLocations() {
        List<Location> returnList = locationRepository.findAll();
        returnList.forEach(location ->
                location.setForecast(getForecastByLocation(location)));
        return returnList;
    }

    public List<Location> filterForecastByDate(LocalDate date){
       List<Location> resulList = List.copyOf(getForecastForAllLocations());
        resulList.forEach(location -> location.getForecast().setData(
                location.getForecast().getData().stream()
                        .filter(weatherDataDTO -> weatherDataDTO.getValid_date().equals(date))
                        .toList())
        );
        return resulList;
    }





}
