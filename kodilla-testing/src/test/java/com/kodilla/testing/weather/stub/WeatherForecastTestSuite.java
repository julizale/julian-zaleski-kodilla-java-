package com.kodilla.testing.weather.stub;

import com.kodilla.testing.library.stub.Temperatures;
import com.kodilla.testing.library.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherForecastTestSuite {

    @Test
    void testCalculateForecastWithStub() {
        //Given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        assertEquals(5, quantityOfSensors);
    }

}
