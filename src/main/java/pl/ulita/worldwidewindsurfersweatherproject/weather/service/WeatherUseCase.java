package pl.ulita.worldwidewindsurfersweatherproject.weather.service;

import pl.ulita.worldwidewindsurfersweatherproject.location.dto.LocationResponseDTO;
import pl.ulita.worldwidewindsurfersweatherproject.location.model.Location;
import pl.ulita.worldwidewindsurfersweatherproject.weather.model.WeatherForecastDTO;

import java.time.LocalDate;
import java.util.List;

public interface WeatherUseCase {

    WeatherForecastDTO getForecastByLocation(Location location);

    List<Location> getForecastForAllLocations();

    List<Location> filterForecastByDate(LocalDate date);

    LocationResponseDTO findLocationWithBestConditions(List<Location> locations);
}
