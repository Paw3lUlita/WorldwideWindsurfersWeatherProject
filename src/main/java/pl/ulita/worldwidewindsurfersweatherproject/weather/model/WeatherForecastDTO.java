package pl.ulita.worldwidewindsurfersweatherproject.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ulita.worldwidewindsurfersweatherproject.weather.dto.WeatherDataDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecastDTO {
    List<WeatherDataDTO> data;
}
