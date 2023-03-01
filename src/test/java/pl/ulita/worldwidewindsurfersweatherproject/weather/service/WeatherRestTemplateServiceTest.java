package pl.ulita.worldwidewindsurfersweatherproject.weather.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.ulita.worldwidewindsurfersweatherproject.location.dto.LocationResponseDTO;
import pl.ulita.worldwidewindsurfersweatherproject.location.model.Location;
import pl.ulita.worldwidewindsurfersweatherproject.location.repository.LocationRepository;
import pl.ulita.worldwidewindsurfersweatherproject.weather.dto.WeatherDataDTO;
import pl.ulita.worldwidewindsurfersweatherproject.weather.dto.WeatherForecastDTO;
import pl.ulita.worldwidewindsurfersweatherproject.weather.httpclient.RestTemplateHttpClient;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WeatherRestTemplateService.class})
class WeatherRestTemplateServiceTest {

    @MockBean
    RestTemplateHttpClient httpClient;

    @Autowired
    WeatherRestTemplateService service;

    @MockBean
    LocationRepository locationRepository;


    @Test
    public void findLocactionWithBestConditionsShouldReturnCorrectValue() {
        //given
        Location location1 = new Location(1, "Jastarnia", "Poland", 54.6960600, 18.6787300, null);
        Location location2 = new Location(2, "BridgeTown", "Barbados", 13.1000000, -59.6166700, null);
        Mockito.when(locationRepository.findAll()).thenReturn(Arrays.asList(location1, location2));
        WeatherDataDTO dataDTO1 = new WeatherDataDTO(LocalDate.parse("2023-03-07"), 23.00, 12.00);
        WeatherDataDTO dataDTO2 = new WeatherDataDTO(LocalDate.parse("2023-03-07"), 24.00, 10.00);
        WeatherDataDTO dataDTO3 = new WeatherDataDTO(LocalDate.parse("2023-03-06"), 20.00, 11.00);
        WeatherDataDTO dataDTO4 = new WeatherDataDTO(LocalDate.parse("2023-03-06"), 15.00, 7.00);

        WeatherForecastDTO forecastDTO1 = new WeatherForecastDTO(Arrays.asList(dataDTO1, dataDTO3));
        WeatherForecastDTO forecastDTO2 = new WeatherForecastDTO(Arrays.asList(dataDTO2, dataDTO4));

        Mockito.when(httpClient.getForecastByLocation(any(Location.class))).thenReturn(forecastDTO1, forecastDTO2);

        //when
        LocalDate date = LocalDate.parse("2023-03-07");
        LocationResponseDTO responseDTO = new LocationResponseDTO("Jastarnia", "Poland", 23.00, 12.00);

        //then
        assertThat(service.findLocationWithBestConditions(date), equalTo(responseDTO));

    }
}
