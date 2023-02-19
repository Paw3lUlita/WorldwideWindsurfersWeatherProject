package pl.ulita.worldwidewindsurfersweatherproject.weather.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import pl.ulita.worldwidewindsurfersweatherproject.location.model.Location;
import pl.ulita.worldwidewindsurfersweatherproject.location.repository.LocationRepository;
import pl.ulita.worldwidewindsurfersweatherproject.weather.dto.WeatherDataDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class WeatherRestTemplateServiceTest {



    @Test
    public void computeConditionsShouldReturnProperValues() {
        //given
        WeatherDataDTO data = new WeatherDataDTO(LocalDate.parse("2023-02-23"), 15, 10);
        RestTemplate restTemplate = new RestTemplate();
        LocationRepositoryStub repository = new LocationRepositoryStub();
        WeatherRestTemplateService service = new WeatherRestTemplateService(restTemplate, repository);

        //when
        double conditions = service.computeConditions(data);

        //then
        assertThat(conditions, equalTo(45.0));
    }

    @Test
    public void computeConditionsShouldReturn0forBadConditions() {
        //given
        WeatherDataDTO data = new WeatherDataDTO(LocalDate.parse("2023-02-23"), 1, 100);
        RestTemplate restTemplate = new RestTemplate();
        LocationRepositoryStub repository = new LocationRepositoryStub();
        WeatherRestTemplateService service = new WeatherRestTemplateService(restTemplate, repository);

        //when
        double conditions = service.computeConditions(data);

        //then
        assertThat(conditions, equalTo(0.0));
    }
}