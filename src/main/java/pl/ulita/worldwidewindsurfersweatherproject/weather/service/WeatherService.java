package pl.ulita.worldwidewindsurfersweatherproject.weather.service;

import pl.ulita.worldwidewindsurfersweatherproject.location.dto.LocationResponseDTO;
import pl.ulita.worldwidewindsurfersweatherproject.location.model.Location;
import pl.ulita.worldwidewindsurfersweatherproject.weather.dto.WeatherForecastDTO;

import java.time.LocalDate;
import java.util.List;

public interface WeatherService {
    LocationResponseDTO findLocationWithBestConditions(LocalDate date);
}
