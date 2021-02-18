package com.autosledz.backend.controller;

import com.autosledz.backend.domain.TraccarDeviceDto;
import com.autosledz.backend.domain.TraccarPositionDto;
import com.autosledz.backend.domain.TraccarUserDto;
import com.autosledz.backend.traccar.facade.TraccarFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/traccar")
@RequiredArgsConstructor
public class TraccarController {
    @Autowired
    private final TraccarFacade traccarFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/devices")
    public List<TraccarDeviceDto> getTraccarDevices() { return traccarFacade.fetchTraccarDevices(); }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<TraccarUserDto> getTraccarUsers() { return traccarFacade.fetchTraccarUsers(); }

    @RequestMapping(method = RequestMethod.GET, value = "/positions")
    public List<TraccarPositionDto> getTraccarPositions() { return traccarFacade.fetchTraccarPositions(); }
}
