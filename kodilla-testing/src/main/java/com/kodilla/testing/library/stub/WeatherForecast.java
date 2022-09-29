package com.kodilla.testing.library.stub;
import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAverageTemperature () {
        double sum = 0;
        for (Map.Entry<String, Double> entry: temperatures.getTemperatures().entrySet()) {
            sum += entry.getValue();
        }
        return sum / temperatures.getTemperatures().size();
    }

    public double calculateMedianTemperature() {
        List<Double> temps = new ArrayList<>();
        for (Map.Entry<String, Double> entry: temperatures.getTemperatures().entrySet()) {
            temps.add(entry.getValue());
        }
        Collections.sort(temps);
        return temps.size() % 2 != 0 ?
                temps.get(temps.size() / 2) :
                ( temps.get(temps.size() / 2) + temps.get(temps.size() / 2 - 1) ) / 2;
    }
}
