package com.autosledz.backend.service;

import com.autosledz.backend.domain.traccar.*;
import com.autosledz.backend.traccar.client.TraccarClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TraccarService {
    private final TraccarClient traccarClient;

    public List<TraccarDeviceDto> fetchTraccarDevices() { return traccarClient.getTraccarDevices(); }

    public List<TraccarUserDto> fetchTraccarUsers() { return traccarClient.getTraccarUsers(); }

    public List<TraccarPositionDto> fetchTraccarPositions() { return traccarClient.getTraccarPositions(); }

    public TraccarServerDto fetchTraccarServer() { return traccarClient.getTraccarServer(); }

    public List<TraccarGroupDto> fetchTraccarGroups() { return traccarClient.getTraccarGroups(); }

    public List<TraccarNotificationDto> fetchTraccarNotifications() { return traccarClient.getTraccarNotifications(); }

    public List<TraccarGeofenceDto> fetchTraccarGeofences() { return traccarClient.getTraccarGeofences(); }

    public List<TraccarCalendarDto> fetchTraccarCalendars() { return traccarClient.getTraccarCalendars(); }
}
