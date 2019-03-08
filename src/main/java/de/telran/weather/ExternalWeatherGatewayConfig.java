package de.telran.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ExternalWeatherGatewayConfig {

    @Value("${weather.token}")
    String token;

    @Autowired
    private RestTemplateBuilder builder;

    @Bean
    public WeatherGateway getWeatherGateway() throws Exception {
        return new WeatherGateway("https://api.openweathermap.org/data/2.5/weather?",
                token,
                getRestTemplate());
    }

    @Bean
    public RestTemplate getRestTemplate() throws Exception {
        RestTemplate template = builder
                //.additionalCustomizers(getCustomizer())
                .build();
        return template;
    }

    @Bean
    public ObjectMapper jacksonObjectMapper() {
        return new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }
}
