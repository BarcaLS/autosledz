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

    @RequestMapping(method = RequestMethod.GET, value = "/groups")
    public List<TraccarGroupDto> getTraccarGroups() {
        service.saveEndpoint(new Endpoint("/v1/traccar/groups" , "GET"));
        return traccarFacade.fetchTraccarGroups();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/notifications")
    public List<TraccarNotificationDto> getTraccarNotifications() {
        service.saveEndpoint(new Endpoint("/v1/traccar/notifications" , "GET"));
        return traccarFacade.fetchTraccarNotifications();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/geofences")
    public List<TraccarGeofenceDto> getTraccarGeofences() {
        service.saveEndpoint(new Endpoint("/v1/traccar/geofences" , "GET"));
        return traccarFacade.fetchTraccarGeofences();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/calendars")
    public List<TraccarCalendarDto> getTraccarCalendars() {
        service.saveEndpoint(new Endpoint("/v1/traccar/calendars" , "GET"));
        return traccarFacade.fetchTraccarCalendars();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/commands")
    public List<TraccarCommandDto> getTraccarCommands() {
        service.saveEndpoint(new Endpoint("/v1/traccar/commands" , "GET"));
        return traccarFacade.fetchTraccarCommands();
    }
}
