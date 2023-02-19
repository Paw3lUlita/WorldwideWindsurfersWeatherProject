package pl.ulita.worldwidewindsurfersweatherproject.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class WeatherDataDTO {
    @JsonProperty("valid_date")
    private LocalDate valid_date;

    @JsonProperty("temp")
    private double temperature;

    @JsonProperty("wind_spd")
    private double windSpeed;
}
