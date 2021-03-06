package com.autosledz.backend.traccar.facade;

import com.autosledz.backend.domain.traccar.*;
import com.autosledz.backend.mapper.TraccarMapper;
import com.autosledz.backend.service.TraccarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TraccarFacade {
    @Autowired
    private TraccarService traccarService;

    @Autowired
    private TraccarMapper traccarMapper;

    public List<TraccarDeviceDto> fetchTraccarDevices() {
        List<TraccarDevice> traccarDevices = traccarMapper.mapToTraccarDevices(traccarService.fetchTraccarDevices());
        return traccarMapper.mapToTraccarDevicesDto(traccarDevices);
    }

    public List<TraccarUserDto> fetchTraccarUsers() {
        List<TraccarUser> traccarUsers = traccarMapper.mapToTraccarUsers(traccarService.fetchTraccarUsers());
        return traccarMapper.mapToTraccarUsersDto(traccarUsers);
    }

    public List<TraccarPositionDto> fetchTraccarPositions() {
        List<TraccarPosition> traccarPositions = traccarMapper.mapToTraccarPositions(traccarService.fetchTraccarPositions());
        return traccarMapper.mapToTraccarPositionsDto(traccarPositions);
    }

    public TraccarServerDto fetchTraccarServer() {
        TraccarServer traccarServer = traccarMapper.mapToTraccarServer(traccarService.fetchTraccarServer());
        return traccarMapper.mapToTraccarServerDto(traccarServer);
    }

    public List<TraccarGroupDto> fetchTraccarGroups() {
        List<TraccarGroup> traccarGroups = traccarMapper.mapToTraccarGroup(traccarService.fetchTraccarGroups());
        return traccarMapper.mapToTraccarGroupDto(traccarGroups);
    }

    public List<TraccarNotificationDto> fetchTraccarNotifications() {
        List<TraccarNotification> traccarNotifications = traccarMapper.mapToTraccarNotification(traccarService.fetchTraccarNotifications());
        return traccarMapper.mapToTraccarNotificationDto(traccarNotifications);
    }

    public List<TraccarGeofenceDto> fetchTraccarGeofences() {
        List<TraccarGeofence> traccarGeofences = traccarMapper.mapToTraccarGeofence(traccarService.fetchTraccarGeofences());
        return traccarMapper.mapToTraccarGeofenceDto(traccarGeofences);
    }

    public List<TraccarCalendarDto> fetchTraccarCalendars() {
        List<TraccarCalendar> traccarCalendars = traccarMapper.mapToTraccarCalendar(traccarService.fetchTraccarCalendars());
        return traccarMapper.mapToTraccarCalendarDto(traccarCalendars);
    }

    public List<TraccarCommandDto> fetchTraccarCommands() {
        List<TraccarCommand> traccarCommands = traccarMapper.mapToTraccarCommand(traccarService.fetchTraccarCommands());
        return traccarMapper.mapToTraccarCommandDto(traccarCommands);
    }

    public List<TraccarDriverDto> fetchTraccarDrivers() {
        List<TraccarDriver> traccarDrivers = traccarMapper.mapToTraccarDriver(traccarService.fetchTraccarDrivers());
        return traccarMapper.mapToTraccarDriverDto(traccarDrivers);
    }
}
