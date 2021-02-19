package com.autosledz.backend.geocoding.client;

import com.autosledz.backend.domain.GeocodingDto;
import com.autosledz.backend.domain.TraccarDeviceDto;
import com.autosledz.backend.geocoding.config.GeocodingConfig;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
public class GeocodingClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeocodingClient.class);

    private final RestTemplate restTemplate;
    private final GeocodingConfig geocodingConfig;

    public GeocodingDto getGeocoding(Float latitude, Float longitude) {
        URI url = UriComponentsBuilder.fromHttpUrl(geocodingConfig.getGeocodingApiEndpoint())
                .queryParam("rapidapi-key", geocodingConfig.getGeocodingAuthorization())
                .queryParam("lat", latitude)
                .queryParam("lon", longitude)
                .queryParam("format", "json")
                .build()
                .encode()
                .toUri();
        try {
            return restTemplate.getForObject(url, GeocodingDto.class);
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new GeocodingDto();
        }
    }
}
