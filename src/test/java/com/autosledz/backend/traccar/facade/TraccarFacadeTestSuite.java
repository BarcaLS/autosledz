package com.autosledz.backend.traccar.facade;

import com.autosledz.backend.domain.traccar.*;
import com.autosledz.backend.mapper.TraccarMapper;
import com.autosledz.backend.service.TraccarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TraccarFacadeTestSuite {
    @InjectMocks
    private TraccarFacade traccarFacade;

    @Mock
    private TraccarService traccarService;

    @Mock
    private TraccarMapper traccarMapper;

    @Test
    void shouldFetchTraccarDevices() {
        // Given
        List<TraccarDeviceDto> traccarDevices = List.of(new TraccarDeviceDto(0L, "Ford", "Mondeo", "sedan"));
        List<TraccarDevice> mappedTraccarDevices = List.of(new TraccarDevice(0L, "Ford", "Mondeo", "sedan"));

        when(traccarService.fetchTraccarDevices()).thenReturn(traccarDevices);
        when(traccarMapper.mapToTraccarDevices(traccarDevices)).thenReturn(mappedTraccarDevices);
        when(traccarMapper.mapToTraccarDevicesDto(anyList())).thenReturn(traccarDevices);

        // When
        List<TraccarDeviceDto> traccarDeviceDtos = traccarFacade.fetchTraccarDevices();

        // Then
        assertThat(traccarDeviceDtos).isNotNull();
        assertThat(traccarDeviceDtos.size()).isEqualTo(1);

        traccarDeviceDtos.forEach(traccarDeviceDto -> {
            assertThat(traccarDeviceDto.getId()).isEqualTo(0);
            assertThat(traccarDeviceDto.getName()).isEqualTo("Ford");
        });
    }

    @Test
    void shouldFetchTraccarUsers() {
        // Given
        List<TraccarUserDto> traccarUsers = List.of(new TraccarUserDto(0L, "John", "john@smith.com", true));
        List<TraccarUser> mappedTraccarUsers = List.of(new TraccarUser(0L, "John", "john@smith.com", true));

        when(traccarService.fetchTraccarUsers()).thenReturn(traccarUsers);
        when(traccarMapper.mapToTraccarUsers(traccarUsers)).thenReturn(mappedTraccarUsers);
        when(traccarMapper.mapToTraccarUsersDto(anyList())).thenReturn(traccarUsers);

        // When
        List<TraccarUserDto> traccarUserDtos = traccarFacade.fetchTraccarUsers();

        // Then
        assertThat(traccarUserDtos).isNotNull();
        assertThat(traccarUserDtos.size()).isEqualTo(1);

        traccarUserDtos.forEach(traccarUserDto -> {
            assertThat(traccarUserDto.getId()).isEqualTo(0);
            assertThat(traccarUserDto.getName()).isEqualTo("John");
        });
    }

    @Test
    void shouldFetchTraccarPositions() {
        // Given
        List<TraccarPositionDto> traccarPositions = List.of(new TraccarPositionDto(0L, 5L, 50.234F, 19.233F));
        List<TraccarPosition> mappedTraccarPositions = List.of(new TraccarPosition(0L, 5L, 50.234F, 19.233F));

        when(traccarService.fetchTraccarPositions()).thenReturn(traccarPositions);
        when(traccarMapper.mapToTraccarPositions(traccarPositions)).thenReturn(mappedTraccarPositions);
        when(traccarMapper.mapToTraccarPositionsDto(anyList())).thenReturn(traccarPositions);

        // When
        List<TraccarPositionDto> traccarPositionDtos = traccarFacade.fetchTraccarPositions();

        // Then
        assertThat(traccarPositionDtos).isNotNull();
        assertThat(traccarPositionDtos.size()).isEqualTo(1);

        traccarPositionDtos.forEach(traccarPositionDto -> {
            assertThat(traccarPositionDto.getId()).isEqualTo(0);
            assertThat(traccarPositionDto.getDeviceId()).isEqualTo(5);
        });
    }

    @Test
    void shouldFetchTraccarServer() {
        // Given
        TraccarServerDto traccarServer = new TraccarServerDto(0L, "http://maps.google.com", 12, "4.12", 0.5F, 1.2F);
        TraccarServer mappedTraccarServer = new TraccarServer(0L, "http://maps.google.com", 12, "4.12", 0.5F, 1.2F);

        when(traccarService.fetchTraccarServer()).thenReturn(traccarServer);
        when(traccarMapper.mapToTraccarServer(traccarServer)).thenReturn(mappedTraccarServer);
        when(traccarMapper.mapToTraccarServerDto(any())).thenReturn(traccarServer);

        // When
        TraccarServerDto traccarServerDto = traccarFacade.fetchTraccarServer();

        // Then
        assertThat(traccarServerDto.getId()).isEqualTo(0);
        assertThat(traccarServerDto.getMapUrl()).isEqualTo("http://maps.google.com");
    }

    @Test
    void shouldFetchTraccarGroups() {
        // Given
        List<TraccarGroupDto> traccarGroups = List.of(new TraccarGroupDto(0L, "grupa praca", 5L));
        List<TraccarGroup> mappedTraccarGroups = List.of(new TraccarGroup(0L, "grupa praca", 5L));

        when(traccarService.fetchTraccarGroups()).thenReturn(traccarGroups);
        when(traccarMapper.mapToTraccarGroup(traccarGroups)).thenReturn(mappedTraccarGroups);
        when(traccarMapper.mapToTraccarGroupDto(anyList())).thenReturn(traccarGroups);

        // When
        List<TraccarGroupDto> traccarGroupDtos = traccarFacade.fetchTraccarGroups();

        // Then
        assertThat(traccarGroupDtos).isNotNull();
        assertThat(traccarGroupDtos.size()).isEqualTo(1);

        traccarGroupDtos.forEach(traccarGroupDto -> {
            assertThat(traccarGroupDto.getId()).isEqualTo(0);
            assertThat(traccarGroupDto.getName()).isEqualTo("grupa praca");
        });
    }

    @Test
    void shouldFetchTraccarNotifications() {
        // Given
        List<TraccarNotificationDto> traccarNotifications = List.of(new TraccarNotificationDto(0L, "number 1", true, false, false, true));
        List<TraccarNotification> mappedTraccarNotifications = List.of(new TraccarNotification(0L, "number 1", true, false, false, true));

        when(traccarService.fetchTraccarNotifications()).thenReturn(traccarNotifications);
        when(traccarMapper.mapToTraccarNotification(traccarNotifications)).thenReturn(mappedTraccarNotifications);
        when(traccarMapper.mapToTraccarNotificationDto(anyList())).thenReturn(traccarNotifications);

        // When
        List<TraccarNotificationDto> traccarNotificationDtos = traccarFacade.fetchTraccarNotifications();

        // Then
        assertThat(traccarNotificationDtos).isNotNull();
        assertThat(traccarNotificationDtos.size()).isEqualTo(1);

        traccarNotificationDtos.forEach(traccarNotificationDto -> {
            assertThat(traccarNotificationDto.getId()).isEqualTo(0);
            assertThat(traccarNotificationDto.getType()).isEqualTo("number 1");
        });
    }

    @Test
    void shouldFetchTraccarGeofences() {
        // Given
        List<TraccarGeofenceDto> traccarGeofences = List.of(new TraccarGeofenceDto(0L, "nazwa", "obszar"));
        List<TraccarGeofence> mappedTraccarGeofences = List.of(new TraccarGeofence(0L, "nazwa", "obszar"));

        when(traccarService.fetchTraccarGeofences()).thenReturn(traccarGeofences);
        when(traccarMapper.mapToTraccarGeofence(traccarGeofences)).thenReturn(mappedTraccarGeofences);
        when(traccarMapper.mapToTraccarGeofenceDto(anyList())).thenReturn(traccarGeofences);

        // When
        List<TraccarGeofenceDto> traccarGeofenceDtos = traccarFacade.fetchTraccarGeofences();

        // Then
        assertThat(traccarGeofenceDtos).isNotNull();
        assertThat(traccarGeofenceDtos.size()).isEqualTo(1);

        traccarGeofenceDtos.forEach(traccarGeofenceDto -> {
            assertThat(traccarGeofenceDto.getId()).isEqualTo(0);
            assertThat(traccarGeofenceDto.getName()).isEqualTo("nazwa");
        });
    }

    @Test
    void shouldFetchTraccarCalendars() {
        // Given
        List<TraccarCalendarDto> traccarCalendars = List.of(new TraccarCalendarDto(0L, "kalendarz 1", "ciąg znaków"));
        List<TraccarCalendar> mappedTraccarCalendars = List.of(new TraccarCalendar(0L, "kalendarz 1", "ciąg znaków"));

        when(traccarService.fetchTraccarCalendars()).thenReturn(traccarCalendars);
        when(traccarMapper.mapToTraccarCalendar(traccarCalendars)).thenReturn(mappedTraccarCalendars);
        when(traccarMapper.mapToTraccarCalendarDto(anyList())).thenReturn(traccarCalendars);

        // When
        List<TraccarCalendarDto> traccarCalendarDtos = traccarFacade.fetchTraccarCalendars();

        // Then
        assertThat(traccarCalendarDtos).isNotNull();
        assertThat(traccarCalendarDtos.size()).isEqualTo(1);

        traccarCalendarDtos.forEach(traccarCalendarDto -> {
            assertThat(traccarCalendarDto.getId()).isEqualTo(0);
            assertThat(traccarCalendarDto.getName()).isEqualTo("kalendarz 1");
        });
    }

    @Test
    void shouldFetchTraccarCommands() {
        // Given
        List<TraccarCommandDto> traccarCalendars = List.of(new TraccarCommandDto(0L, 450L, "opis1", "typ1"));
        List<TraccarCommand> mappedTraccarCalendars = List.of(new TraccarCommand(0L, 450L, "opis1", "typ1"));

        when(traccarService.fetchTraccarCommands()).thenReturn(traccarCalendars);
        when(traccarMapper.mapToTraccarCommand(traccarCalendars)).thenReturn(mappedTraccarCalendars);
        when(traccarMapper.mapToTraccarCommandDto(anyList())).thenReturn(traccarCalendars);

        // When
        List<TraccarCommandDto> traccarCommandDtos = traccarFacade.fetchTraccarCommands();

        // Then
        assertThat(traccarCommandDtos).isNotNull();
        assertThat(traccarCommandDtos.size()).isEqualTo(1);

        traccarCommandDtos.forEach(traccarCommandDto -> {
            assertThat(traccarCommandDto.getId()).isEqualTo(0);
            assertThat(traccarCommandDto.getDescription()).isEqualTo("opis1");
        });
    }

    @Test
    void shouldFetchTraccarDrivers() {
        // Given
        List<TraccarDriverDto> traccarDrivers = List.of(new TraccarDriverDto(0L, "Zenek", "123"));
        List<TraccarDriver> mappedTraccarDrivers = List.of(new TraccarDriver(0L, "Zenek", "123"));

        when(traccarService.fetchTraccarDrivers()).thenReturn(traccarDrivers);
        when(traccarMapper.mapToTraccarDriver(traccarDrivers)).thenReturn(mappedTraccarDrivers);
        when(traccarMapper.mapToTraccarDriverDto(anyList())).thenReturn(traccarDrivers);

        // When
        List<TraccarDriverDto> traccarDriverDtos = traccarFacade.fetchTraccarDrivers();

        // Then
        assertThat(traccarDriverDtos).isNotNull();
        assertThat(traccarDriverDtos.size()).isEqualTo(1);

        traccarDriverDtos.forEach(traccarDriverDto -> {
            assertThat(traccarDriverDto.getId()).isEqualTo(0);
            assertThat(traccarDriverDto.getName()).isEqualTo("Zenek");
        });
    }
}
