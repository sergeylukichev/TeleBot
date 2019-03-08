package de.telran.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService {

    private WeatherGateway gateway;

    public WeatherService(@Autowired WeatherGateway gateway) {
        this.gateway = gateway;
    }

    public double getWeatherInCity(String city) {
        Optional<Double> forecastByCity = gateway.getForecastByCity(city);
        if(forecastByCity.isPresent()) {
            return forecastByCity.get().doubleValue();
        }
        return 0;
    }
}
