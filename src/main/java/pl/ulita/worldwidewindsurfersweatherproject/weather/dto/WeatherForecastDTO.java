package pl.ulita.worldwidewindsurfersweatherproject.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.ulita.worldwidewindsurfersweatherproject.weather.dto.WeatherDataDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecastDTO {
    List<WeatherDataDTO> data;
}
