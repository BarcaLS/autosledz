package com.autosledz.backend.mapper;

import com.autosledz.backend.domain.traccar.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TraccarMapperTestSuite {
    @Autowired
    private TraccarMapper traccarMapper;

    @Test
    public void mapToTraccarDevices() {
        // Given
        TraccarDeviceDto traccarDeviceDto1 = new TraccarDeviceDto(0L, "Ford", "Mondeo", "sedan");
        TraccarDeviceDto traccarDeviceDto2 = new TraccarDeviceDto(1L, "Opel", "Astra", "hatchback");

        // When
        List<TraccarDevice> traccarDevices = traccarMapper.mapToTraccarDevices(List.of(traccarDeviceDto1, traccarDeviceDto2));

        // Then
        assertEquals(2, traccarDevices.size());
    }

    @Test
    public void mapToTraccarDevicesDto() {
        // Given
        TraccarDevice traccarDevice1 = new TraccarDevice(0L, "Ford", "Mondeo", "sedan");
        TraccarDevice traccarDevice2 = new TraccarDevice(1L, "Opel", "Astra", "hatchback");

        // When
        List<TraccarDeviceDto> traccarDeviceDtos = traccarMapper.mapToTraccarDevicesDto(List.of(traccarDevice1, traccarDevice2));

        // Then
        assertEquals(2, traccarDeviceDtos.size());
    }

    @Test
    public void mapToTraccarUsers() {
        // Given
        TraccarUserDto traccarUserDto1 = new TraccarUserDto(0L, "John", "john@smith.com", true);
        TraccarUserDto traccarUserDto2 = new TraccarUserDto(0L, "John", "john@smith.com", true);

        // When
        List<TraccarUser> traccarUsers = traccarMapper.mapToTraccarUsers(List.of(traccarUserDto1, traccarUserDto2));

        // Then
        assertEquals(2, traccarUsers.size());
    }

    @Test
    public void mapToTraccarUsersDto() {
        // Given
        TraccarUser traccarUser1 = new TraccarUser(0L, "John", "john@smith.com", true);
        TraccarUser traccarUser2 = new TraccarUser(0L, "John", "john@smith.com", true);

        // When
        List<TraccarUserDto> traccarUserDtos = traccarMapper.mapToTraccarUsersDto(List.of(traccarUser1, traccarUser2));

        // Then
        assertEquals(2, traccarUserDtos.size());
    }

    @Test
    public void mapToTraccarPositions() {
        // Given
        TraccarPositionDto traccarPositionDto1 = new TraccarPositionDto(0L, 5L, 50.234F, 19.233F);
        TraccarPositionDto traccarPositionDto2 = new TraccarPositionDto(1L, 4L, 48.583F, 16.087F);

        // When
        List<TraccarPosition> traccarPositions = traccarMapper.mapToTraccarPositions(List.of(traccarPositionDto1, traccarPositionDto2));

        // Then
        assertEquals(2, traccarPositions.size());
    }

    @Test
    public void mapToTraccarPositionsDto() {
        // Given
        TraccarPosition traccarPosition1 = new TraccarPosition(0L, 5L, 50.234F, 19.233F);
        TraccarPosition traccarPosition2 = new TraccarPosition(1L, 4L, 48.583F, 16.087F);

        // When
        List<TraccarPositionDto> traccarPositionDtos = traccarMapper.mapToTraccarPositionsDto(List.of(traccarPosition1, traccarPosition2));

        // Then
        assertEquals(2, traccarPositionDtos.size());
    }

    @Test
    public void mapToTraccarServer() {
        // Given
        TraccarServerDto traccarServerDto = new TraccarServerDto(0L, "http://maps.google.com", 12, "4.12", 0.5F, 1.2F);

        // When
        TraccarServer traccarServer = traccarMapper.mapToTraccarServer(traccarServerDto);

        // Then
        assertEquals("http://maps.google.com", traccarServer.getMapUrl());
    }

    @Test
    public void mapToTraccarServerDto() {
        // Given
        TraccarServer traccarServer = new TraccarServer(0L, "http://maps.google.com", 12, "4.12", 0.5F, 1.2F);

        // When
        TraccarServerDto traccarServerDto = traccarMapper.mapToTraccarServerDto(traccarServer);

        // Then
        assertEquals("http://maps.google.com", traccarServerDto.getMapUrl());
    }

    @Test
    public void mapToTraccarGroup() {
        // Given
        TraccarGroupDto traccarGroupDto1 = new TraccarGroupDto(0L, "grupa praca", 5L);
        TraccarGroupDto traccarGroupDto2 = new TraccarGroupDto(1L, "grupa dom", 6L);

        // When
        List<TraccarGroup> traccarGroups = traccarMapper.mapToTraccarGroup(List.of(traccarGroupDto1, traccarGroupDto2));

        // Then
        assertEquals(2, traccarGroups.size());
    }

    @Test
    public void mapToTraccarGroupDto() {
        // Given
        TraccarGroup traccarGroup1 = new TraccarGroup(0L, "grupa praca", 5L);
        TraccarGroup traccarGroup2 = new TraccarGroup(1L, "grupa dom", 6L);

        // When
        List<TraccarGroupDto> traccarGroupDtos = traccarMapper.mapToTraccarGroupDto(List.of(traccarGroup1, traccarGroup2));

        // Then
        assertEquals(2, traccarGroupDtos.size());
    }

    @Test
    public void mapToTraccarNotification() {
        // Given
        TraccarNotificationDto traccarNotificationDto1 = new TraccarNotificationDto(0L, "number 1", true, false, false, true);
        TraccarNotificationDto traccarNotificationDto2 = new TraccarNotificationDto(1L, "number 2", false, true, true, true);

        // When
        List<TraccarNotification> traccarNotifications = traccarMapper.mapToTraccarNotification(List.of(traccarNotificationDto1, traccarNotificationDto2));

        // Then
        assertEquals(2, traccarNotifications.size());
    }

    @Test
    public void mapToTraccarNotificationDto() {
        // Given
        TraccarNotification traccarNotification1 = new TraccarNotification(0L, "number 1", true, false, false, true);
        TraccarNotification traccarNotification2 = new TraccarNotification(1L, "number 2", false, true, true, true);

        // When
        List<TraccarNotificationDto> traccarNotificationDtos = traccarMapper.mapToTraccarNotificationDto(List.of(traccarNotification1, traccarNotification2));

        // Then
        assertEquals(2, traccarNotificationDtos.size());
    }

    @Test
    public void mapToTraccarGeofence() {
        // Given
        TraccarGeofenceDto traccarGeofenceDto1 = new TraccarGeofenceDto(0L, "nazwa", "obszar");
        TraccarGeofenceDto traccarGeofenceDto2 = new TraccarGeofenceDto(1L, "inna nazwa", "inny obszar");

        // When
        List<TraccarGeofence> traccarGeofences = traccarMapper.mapToTraccarGeofence(List.of(traccarGeofenceDto1, traccarGeofenceDto2));

        // Then
        assertEquals(2, traccarGeofences.size());
    }

    @Test
    public void mapToTraccarGeofenceDto() {
        // Given
        TraccarGeofence traccarGeofence1 = new TraccarGeofence(0L, "nazwa", "obszar");
        TraccarGeofence traccarGeofence2 = new TraccarGeofence(1L, "inna nazwa", "inny obszar");

        // When
        List<TraccarGeofenceDto> traccarGeofenceDtos = traccarMapper.mapToTraccarGeofenceDto(List.of(traccarGeofence1, traccarGeofence2));

        // Then
        assertEquals(2, traccarGeofenceDtos.size());
    }

    @Test
    public void mapToTraccarCalendar() {
        // Given
        TraccarCalendarDto traccarCalendarDto1 = new TraccarCalendarDto(0L, "kalendarz 1", "ciąg znaków");
        TraccarCalendarDto traccarCalendarDto2 = new TraccarCalendarDto(1L, "kalendarz 2", "jakiś inny ciąg znaków");

        // When
        List<TraccarCalendar> traccarCalendars = traccarMapper.mapToTraccarCalendar(List.of(traccarCalendarDto1, traccarCalendarDto2));

        // Then
        assertEquals(2, traccarCalendars.size());
    }

    @Test
    public void mapToTraccarCalendarDto() {
        // Given
        TraccarCalendar traccarCalendar1 = new TraccarCalendar(0L, "kalendarz 1", "ciąg znaków");
        TraccarCalendar traccarCalendar2 = new TraccarCalendar(1L, "kalendarz 2", "jakiś inny ciąg znaków");

        // When
        List<TraccarCalendarDto> traccarCalendarDtos = traccarMapper.mapToTraccarCalendarDto(List.of(traccarCalendar1, traccarCalendar2));

        // Then
        assertEquals(2, traccarCalendarDtos.size());
    }

    @Test
    public void mapToTraccarCommand() {
        // Given
        TraccarCommandDto traccarCommandDto1 = new TraccarCommandDto(0L, 450L, "opis1", "typ1");
        TraccarCommandDto traccarCommandDto2 = new TraccarCommandDto(1L, 230L, "opis2", "typ2");

        // When
        List<TraccarCommand> traccarCommands = traccarMapper.mapToTraccarCommand(List.of(traccarCommandDto1, traccarCommandDto2));

        // Then
        assertEquals(2, traccarCommands.size());
    }

    @Test
    public void mapToTraccarCommandDto() {
        // Given
        TraccarCommand traccarCommand1 = new TraccarCommand(0L, 450L, "opis1", "typ1");
        TraccarCommand traccarCommand2 = new TraccarCommand(1L, 230L, "opis2", "typ2");

        // When
        List<TraccarCommandDto> traccarCommandDtos = traccarMapper.mapToTraccarCommandDto(List.of(traccarCommand1, traccarCommand2));

        // Then
        assertEquals(2, traccarCommandDtos.size());
    }

    @Test
    public void mapToTraccarDriver() {
        // Given
        TraccarDriverDto traccarCommandDto1 = new TraccarDriverDto(0L, "Zenek", "123");
        TraccarDriverDto traccarCommandDto2 = new TraccarDriverDto(1L, "Bogdan", "456");

        // When
        List<TraccarDriver> traccarDrivers = traccarMapper.mapToTraccarDriver(List.of(traccarCommandDto1, traccarCommandDto2));

        // Then
        assertEquals(2, traccarDrivers.size());
    }

    @Test
    public void mapToTraccarDriverDto() {
        // Given
        TraccarDriver traccarCommand1 = new TraccarDriver(0L, "Zenek", "123");
        TraccarDriver traccarCommand2 = new TraccarDriver(1L, "Bogdan", "456");

        // When
        List<TraccarDriverDto> traccarDriverDtos = traccarMapper.mapToTraccarDriverDto(List.of(traccarCommand1, traccarCommand2));

        // Then
        assertEquals(2, traccarDriverDtos.size());
    }
}
