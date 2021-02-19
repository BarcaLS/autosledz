package com.autosledz.backend.controller;

import com.autosledz.backend.domain.GeocodingDto;
import com.autosledz.backend.service.GeocodingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/geocoding")
@RequiredArgsConstructor
public class GeocodingController {
    @Autowired
    private GeocodingService geocodingService;

    @RequestMapping(method = RequestMethod.GET, value = "/get/{latitude}/{longitude}")
    public GeocodingDto getGeocoding(@PathVariable Float latitude, @PathVariable Float longitude) {
        return geocodingService.getGeocoding(latitude, longitude);
    }
}
