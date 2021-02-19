package com.autosledz.backend.service;

import com.autosledz.backend.domain.GeocodingDto;
import com.autosledz.backend.geocoding.client.GeocodingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeocodingService {
    private final GeocodingClient geocodingClient;

    public GeocodingDto getGeocoding(Float latitude, Float longitude) { return geocodingClient.getGeocoding(latitude, longitude); }
}
