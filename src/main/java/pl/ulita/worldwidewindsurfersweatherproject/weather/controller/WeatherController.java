package pl.ulita.worldwidewindsurfersweatherproject.weather.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.ulita.worldwidewindsurfersweatherproject.location.dto.LocationResponseDTO;
import pl.ulita.worldwidewindsurfersweatherproject.location.model.Location;
import pl.ulita.worldwidewindsurfersweatherproject.weather.service.WeatherUseCase;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@Data
public class WeatherController {
    private final WeatherUseCase service;

    @GetMapping("/bestconditions/{date}")
    public LocationResponseDTO getForecast(@PathVariable String date){
        LocalDate date1 = LocalDate.parse(date);
        List<Location> filteredLocations = service.filterForecastByDate(date1);
        return service.findLocationWithBestConditions(filteredLocations);
    }
}
