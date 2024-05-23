package org.example.orem.domain.weather.controller;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
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



    @GetMapping
    public Map<String, Object> getWeather() {
        Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("krmp-proxy.9rum.cc", 3128));
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setProxy(proxy);
        restTemplate = new RestTemplate(requestFactory);
        String url = String.format("%s?lat=%f&lon=%f&appid=%s&units=%s", API_URL, lat, lon, API_KEY, units);
        return restTemplate.getForObject(url, Map.class);
    }

}
