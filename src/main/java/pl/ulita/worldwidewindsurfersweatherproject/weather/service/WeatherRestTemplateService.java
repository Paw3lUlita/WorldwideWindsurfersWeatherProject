package pl.ulita.worldwidewindsurfersweatherproject.weather.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.ulita.worldwidewindsurfersweatherproject.location.model.Location;
import pl.ulita.worldwidewindsurfersweatherproject.weather.model.WeatherForecastDTO;

@Service
@AllArgsConstructor
@Data
public class WeatherRestTemplateService implements WeatherUseCase {
    private final String API_KEY = "de91367822fd435b9347e0dde4d3c8ab";
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherForecastDTO getForecastByLocation(Location location) {
        return restTemplate.getForObject(
                "https://api.weatherbit.io/v2.0/forecast/daily?lat={latitude}&lon={longtitude}&key={API_KEY}",
                WeatherForecastDTO.class, location.getLatitude(), location.getLongtitude(), API_KEY);
    }
}
