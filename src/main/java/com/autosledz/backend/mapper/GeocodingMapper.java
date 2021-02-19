package com.autosledz.backend.mapper;

import com.autosledz.backend.domain.Geocoding;
import com.autosledz.backend.domain.GeocodingDto;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class GeocodingMapper {
    public List<Geocoding> mapToGeocoding(final List<GeocodingDto> geocodingDto) {
        return geocodingDto.stream()
                .map(geocoding ->
                        new Geocoding(geocoding.getDisplayName()))
                .collect(toList());
    }

    public List<GeocodingDto> mapToGeocodingDto(final List<Geocoding> geocodings) {
        return geocodings.stream()
                .map(geocoding ->
                        new GeocodingDto(geocoding.getDisplayName()))
                .collect(toList());
    }
}
