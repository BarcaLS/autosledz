package com.autosledz.backend.controller;

import com.autosledz.backend.domain.Endpoint;
import com.autosledz.backend.domain.GeocodingDto;
import com.autosledz.backend.service.DbService;
import com.autosledz.backend.service.GeocodingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/geocoding")
@RequiredArgsConstructor
public class GeocodingController {
    private final GeocodingService geocodingService;
    private final DbService service;

    @RequestMapping(method = RequestMethod.GET, value = "/get/{latitude}/{longitude}")
    public GeocodingDto getGeocoding(@PathVariable Float latitude, @PathVariable Float longitude) {
        service.saveEndpoint(new Endpoint("/v1/geocoding/get" + latitude + "/" + longitude, "GET"));
        return geocodingService.getGeocoding(latitude, longitude);
    }
}
