package org.example.orem.domain.weather.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final String units = "metric";
    @Value("${weather-api-key}")
    private String API_KEY;
    double lat = 33.4500452;
    double lon = 126.9184399;

    private RestTemplate restTemplate;

    public WeatherController() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping
    public Map<String, Object> getWeather() {
        String url = String.format("%s?lat=%f&lon=%f&appid=%s&units=%s", API_URL, lat, lon, API_KEY, units);
        return restTemplate.getForObject(url, Map.class);
    }

}
