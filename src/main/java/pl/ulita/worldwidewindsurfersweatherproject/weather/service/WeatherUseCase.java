package pl.ulita.worldwidewindsurfersweatherproject.weather.service;

import pl.ulita.worldwidewindsurfersweatherproject.location.model.Location;
import pl.ulita.worldwidewindsurfersweatherproject.weather.model.WeatherForecastDTO;

public interface WeatherUseCase {

    WeatherForecastDTO getForecastByLocation(Location location);
}
