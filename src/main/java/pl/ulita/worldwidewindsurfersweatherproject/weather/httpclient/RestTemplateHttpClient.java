package pl.ulita.worldwidewindsurfersweatherproject.weather.httpclient;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.ulita.worldwidewindsurfersweatherproject.location.model.Location;
import pl.ulita.worldwidewindsurfersweatherproject.location.repository.LocationRepository;
import pl.ulita.worldwidewindsurfersweatherproject.weather.dto.WeatherForecastDTO;

@Component
@AllArgsConstructor
public class RestTemplateHttpClient {

    private static final String API_KEY = "de91367822fd435b9347e0dde4d3c8ab";
    private final RestTemplate restTemplate;

    public WeatherForecastDTO getForecastByLocation(Location location) {
        return restTemplate.getForObject(
                "https://api.weatherbit.io/v2.0/forecast/daily?lat={latitude}&lon={longtitude}&key={API_KEY}",
                WeatherForecastDTO.class, location.getLatitude(), location.getLongtitude(), API_KEY);
    }

}
