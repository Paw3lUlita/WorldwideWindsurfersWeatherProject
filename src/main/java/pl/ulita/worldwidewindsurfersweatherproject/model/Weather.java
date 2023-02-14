package pl.ulita.worldwidewindsurfersweatherproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    @JsonProperty("valid_date")
    private LocalDate valid_date;

    @JsonProperty("temp")
    private double temperature;

    @JsonProperty("wind_spd")
    private double windSpeed;
}
