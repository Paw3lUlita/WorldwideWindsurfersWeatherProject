package pl.ulita.worldwidewindsurfersweatherproject.location.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponseDTO {
    private String name;
    //jesli nie uzywasz adnotacji nad zadnym polem to nie musisz robic entera pomiedzy polami

    private String country;

    private double temperature;

    private double windSpeed;
}
