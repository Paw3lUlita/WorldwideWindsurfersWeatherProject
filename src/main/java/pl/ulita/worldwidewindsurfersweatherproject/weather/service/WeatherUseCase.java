package pl.ulita.worldwidewindsurfersweatherproject.weather.service;

import pl.ulita.worldwidewindsurfersweatherproject.location.dto.LocationResponseDTO;
import pl.ulita.worldwidewindsurfersweatherproject.location.model.Location;
import pl.ulita.worldwidewindsurfersweatherproject.weather.dto.WeatherForecastDTO;

import java.time.LocalDate;
import java.util.List;

//nieodpowiednia nazwa, WeatherService lub cos w tym stylu
public interface WeatherUseCase {

    //tutaj raczej powinna byc wystawiona jedna metoda dla controllera, reszta z tych metod powinna juz byc tylko jako prywatne w implementacji tej klasy

    WeatherForecastDTO getForecastByLocation(Location location);

    List<Location> getForecastForAllLocations();

    List<Location> filterForecastByDate(LocalDate date);

    LocationResponseDTO findLocationWithBestConditions(List<Location> locations);
}
