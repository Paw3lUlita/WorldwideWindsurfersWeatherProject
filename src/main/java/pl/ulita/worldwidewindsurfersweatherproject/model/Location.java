package pl.ulita.worldwidewindsurfersweatherproject.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String country;

    private double latitude;

    private double longtitude;

    @Transient
    private Weather weather;
}
