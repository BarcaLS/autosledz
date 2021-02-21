package com.autosledz.backend.controller;

import com.autosledz.backend.domain.Endpoint;
import com.autosledz.backend.domain.traccar.*;
import com.autosledz.backend.service.DbService;
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
    private final TraccarFacade traccarFacade;
    private final DbService service;

    @RequestMapping(method = RequestMethod.GET, value = "/devices")
    public List<TraccarDeviceDto> getTraccarDevices() {
        service.saveEndpoint(new Endpoint("/v1/traccar/devices" , "GET"));
        return traccarFacade.fetchTraccarDevices();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<TraccarUserDto> getTraccarUsers() {
        service.saveEndpoint(new Endpoint("/v1/traccar/users" , "GET"));
        return traccarFacade.fetchTraccarUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/positions")
    public List<TraccarPositionDto> getTraccarPositions() {
        service.saveEndpoint(new Endpoint("/v1/traccar/positions" , "GET"));
        return traccarFacade.fetchTraccarPositions();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/server")
    public TraccarServerDto getTraccarServer() {
        service.saveEndpoint(new Endpoint("/v1/traccar/server" , "GET"));
        return traccarFacade.fetchTraccarServer();
    }
}
