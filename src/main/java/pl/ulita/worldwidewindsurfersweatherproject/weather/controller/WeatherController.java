package pl.ulita.worldwidewindsurfersweatherproject.weather.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.ulita.worldwidewindsurfersweatherproject.location.dto.LocationResponseDTO;
import pl.ulita.worldwidewindsurfersweatherproject.weather.service.WeatherService;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
public class WeatherController {
    private final WeatherService service;

    @GetMapping("/bestconditions/{date}")
    public LocationResponseDTO getForecast(@PathVariable String date){
        LocalDate date1 = LocalDate.parse(date);;
        return service.findLocationWithBestConditions(date1);
    }
}
