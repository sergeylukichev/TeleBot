package de.telran.weather;

import de.telran.weather.model.SearchResult;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public class WeatherGateway {
    String url;
    String apiKey;
    RestTemplate rest;

    public WeatherGateway(String url, String apiKey, RestTemplate rest) {
        this.url = url;
        this.apiKey = apiKey;
        this.rest = rest;
    }

    public Optional<Double> getForecastByCity(String city) {
        String targetUrl = url + "q=" + city + "&" + apiKey + "&units=metric";
        System.out.println(targetUrl);
        ResponseEntity<SearchResult> exchange = rest.exchange(targetUrl, HttpMethod.GET, null, SearchResult.class);
        return Optional.of(exchange.getBody().getMain().getTemp());
    }
}
