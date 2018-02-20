package com.example.demo.gateway;

import com.example.demo.dto.WeatherDTO;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class WeatherGateway {

    @Value("${weather.link}")
    private String weatherLink;

    @Value("${weather.appid}")
    private String appid;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherDTO getCurrentWeather(String cityId) throws URISyntaxException, RestClientException {
        return restTemplate.getForObject(getUri(cityId), WeatherDTO.class);
    }

    private URI getUri(String cityId) throws URISyntaxException {
        URIBuilder builder = new URIBuilder(weatherLink);
        builder.addParameter("id", cityId);
        builder.addParameter("APPID", appid);
        return builder.build();
    }
}
