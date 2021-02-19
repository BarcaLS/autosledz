package com.autosledz.backend.geocoding.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class GeocodingConfig {
    @Value("${geocoding.api.endpoint.prod}")
    private String geocodingApiEndpoint;
    @Value("${geocoding.rapidapi.key}")
    private String geocodingAuthorization;
}
