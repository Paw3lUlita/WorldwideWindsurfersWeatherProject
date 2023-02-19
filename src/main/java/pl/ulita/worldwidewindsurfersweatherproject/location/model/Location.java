package pl.ulita.worldwidewindsurfersweatherproject.location.model;

import jakarta.persistence.*;
import lombok.*;
import pl.ulita.worldwidewindsurfersweatherproject.weather.dto.WeatherForecastDTO;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String country;

    private double latitude;

    private double longtitude;

    @Transient
    private WeatherForecastDTO forecast;
}
