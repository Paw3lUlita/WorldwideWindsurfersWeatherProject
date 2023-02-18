package pl.ulita.worldwidewindsurfersweatherproject.weather.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ulita.worldwidewindsurfersweatherproject.location.model.Location;
import pl.ulita.worldwidewindsurfersweatherproject.weather.model.WeatherForecastDTO;
import pl.ulita.worldwidewindsurfersweatherproject.weather.service.WeatherRestTemplateService;
import pl.ulita.worldwidewindsurfersweatherproject.weather.service.WeatherUseCase;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@Data
public class WeatherController {
    private final WeatherUseCase service;

    @GetMapping("/weather")
    public WeatherForecastDTO getForecast(){
        String date = "2023-02-19";
        LocalDate date1 = LocalDate.parse(date);
        return service.filterForecastByDate(date1).get(0).getForecast();
    }
}
