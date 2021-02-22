package com.autosledz.backend.traccar.client;

import com.autosledz.backend.domain.traccar.*;
import com.autosledz.backend.traccar.config.TraccarConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TraccarClientTestSuite {
    @InjectMocks
    @Autowired
    private TraccarClient traccarClient;

    @MockBean
    private RestTemplate restTemplate;

    @MockBean
    private TraccarConfig traccarConfig;

    HttpEntity createEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add(HttpHeaders.AUTHORIZATION, traccarConfig.getTraccarAuthorization());
        return new HttpEntity(headers);
    }

    @Test
    public void shouldFetchTraccarDevices() {
        // Given
        when(traccarConfig.getTraccarApiEndpoint()).thenReturn("http://test.com");
        when(traccarConfig.getTraccarAuthorization()).thenReturn("test");

        TraccarDeviceDto[] traccarDeviceDtos = new TraccarDeviceDto[1];
        traccarDeviceDtos[0] = new TraccarDeviceDto(0L, "Ford", "Mondeo", "sedan");
        ResponseEntity<TraccarDeviceDto[]> responseEntity = new ResponseEntity<TraccarDeviceDto[]>(
                traccarDeviceDtos,
                HttpStatus.OK
        );

        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/devices")
                .build()
                .encode()
                .toUri();
        HttpEntity entity = createEntity();

        when(restTemplate.exchange(url, HttpMethod.GET, entity, TraccarDeviceDto[].class)).thenReturn(responseEntity);

        // When
        List<TraccarDeviceDto> fetchedTraccarDevices = traccarClient.getTraccarDevices();

        // Then
        assertEquals(1, fetchedTraccarDevices.size());
        assertEquals(0, fetchedTraccarDevices.get(0).getId());
        assertEquals("Ford", fetchedTraccarDevices.get(0).getName());
    }

    @Test
    public void shouldFetchTraccarUsers() {
        // Given
        when(traccarConfig.getTraccarApiEndpoint()).thenReturn("http://test.com");
        when(traccarConfig.getTraccarAuthorization()).thenReturn("test");

        TraccarUserDto[] traccarUserDtos = new TraccarUserDto[1];
        traccarUserDtos[0] = new TraccarUserDto(0L, "John", "john@smith.com", true);
        ResponseEntity<TraccarUserDto[]> responseEntity = new ResponseEntity<TraccarUserDto[]>(
                traccarUserDtos,
                HttpStatus.OK
        );

        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/users")
                .build()
                .encode()
                .toUri();
        HttpEntity entity = createEntity();

        when(restTemplate.exchange(url, HttpMethod.GET, entity, TraccarUserDto[].class)).thenReturn(responseEntity);

        // When
        List<TraccarUserDto> fetchedTraccarUsers = traccarClient.getTraccarUsers();

        // Then
        assertEquals(1, fetchedTraccarUsers.size());
        assertEquals(0, fetchedTraccarUsers.get(0).getId());
        assertEquals("John", fetchedTraccarUsers.get(0).getName());
    }

    @Test
    public void shouldFetchTraccarPositions() {
        // Given
        when(traccarConfig.getTraccarApiEndpoint()).thenReturn("http://test.com");
        when(traccarConfig.getTraccarAuthorization()).thenReturn("test");

        TraccarPositionDto[] traccarPositionDtos = new TraccarPositionDto[1];
        traccarPositionDtos[0] = new TraccarPositionDto(0L, 5L, 50.234F, 19.233F);
        ResponseEntity<TraccarPositionDto[]> responseEntity = new ResponseEntity<TraccarPositionDto[]>(
                traccarPositionDtos,
                HttpStatus.OK
        );

        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/positions")
                .build()
                .encode()
                .toUri();
        HttpEntity entity = createEntity();

        when(restTemplate.exchange(url, HttpMethod.GET, entity, TraccarPositionDto[].class)).thenReturn(responseEntity);

        // When
        List<TraccarPositionDto> fetchedTraccarPositions = traccarClient.getTraccarPositions();

        // Then
        assertEquals(1, fetchedTraccarPositions.size());
        assertEquals(0, fetchedTraccarPositions.get(0).getId());
        assertEquals(50.234F, fetchedTraccarPositions.get(0).getLatitude());
    }

    @Test
    public void shouldFetchTraccarServer() {
        // Given
        when(traccarConfig.getTraccarApiEndpoint()).thenReturn("http://test.com");
        when(traccarConfig.getTraccarAuthorization()).thenReturn("test");

        TraccarServerDto traccarServerDto = new TraccarServerDto(0L, "http://maps.google.com", 12, "4.12", 0.5F, 1.2F);
        ResponseEntity<TraccarServerDto> responseEntity = new ResponseEntity<TraccarServerDto>(
                traccarServerDto,
                HttpStatus.OK
        );

        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/server")
                .build()
                .encode()
                .toUri();
        HttpEntity entity = createEntity();

        when(restTemplate.exchange(url, HttpMethod.GET, entity, TraccarServerDto.class)).thenReturn(responseEntity);

        // When
        TraccarServerDto fetchedTraccarServer = traccarClient.getTraccarServer();

        // Then
        assertEquals(0, fetchedTraccarServer.getId());
        assertEquals("http://maps.google.com", fetchedTraccarServer.getMapUrl());
    }

    @Test
    public void shouldFetchTraccarGroups() {
        // Given
        when(traccarConfig.getTraccarApiEndpoint()).thenReturn("http://test.com");
        when(traccarConfig.getTraccarAuthorization()).thenReturn("test");

        TraccarGroupDto[] traccarGroupDtos = new TraccarGroupDto[1];
        traccarGroupDtos[0] = new TraccarGroupDto(0L, "grupa praca", 5L);
        ResponseEntity<TraccarGroupDto[]> responseEntity = new ResponseEntity<TraccarGroupDto[]>(
                traccarGroupDtos,
                HttpStatus.OK
        );

        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/groups")
                .build()
                .encode()
                .toUri();
        HttpEntity entity = createEntity();

        when(restTemplate.exchange(url, HttpMethod.GET, entity, TraccarGroupDto[].class)).thenReturn(responseEntity);

        // When
        List<TraccarGroupDto> fetchedTraccarGroups = traccarClient.getTraccarGroups();

        // Then
        assertEquals(1, fetchedTraccarGroups.size());
        assertEquals(0, fetchedTraccarGroups.get(0).getId());
        assertEquals("grupa praca", fetchedTraccarGroups.get(0).getName());
    }

    @Test
    public void shouldFetchTraccarNotifications() {
        // Given
        when(traccarConfig.getTraccarApiEndpoint()).thenReturn("http://test.com");
        when(traccarConfig.getTraccarAuthorization()).thenReturn("test");

        TraccarNotificationDto[] traccarNotificationDtos = new TraccarNotificationDto[1];
        traccarNotificationDtos[0] = new TraccarNotificationDto(0L, "number 1", true, false, false, true);
        ResponseEntity<TraccarNotificationDto[]> responseEntity = new ResponseEntity<TraccarNotificationDto[]>(
                traccarNotificationDtos,
                HttpStatus.OK
        );

        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/notifications")
                .build()
                .encode()
                .toUri();
        HttpEntity entity = createEntity();

        when(restTemplate.exchange(url, HttpMethod.GET, entity, TraccarNotificationDto[].class)).thenReturn(responseEntity);

        // When
        List<TraccarNotificationDto> fetchedTraccarNotifications = traccarClient.getTraccarNotifications();

        // Then
        assertEquals(1, fetchedTraccarNotifications.size());
        assertEquals(0, fetchedTraccarNotifications.get(0).getId());
        assertEquals("number 1", fetchedTraccarNotifications.get(0).getType());
    }

    @Test
    public void shouldFetchTraccarGeofences() {
        // Given
        when(traccarConfig.getTraccarApiEndpoint()).thenReturn("http://test.com");
        when(traccarConfig.getTraccarAuthorization()).thenReturn("test");

        TraccarGeofenceDto[] traccarGeofenceDtos = new TraccarGeofenceDto[1];
        traccarGeofenceDtos[0] = new TraccarGeofenceDto(0L, "nazwa", "obszar");
        ResponseEntity<TraccarGeofenceDto[]> responseEntity = new ResponseEntity<TraccarGeofenceDto[]>(
                traccarGeofenceDtos,
                HttpStatus.OK
        );

        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/geofences")
                .build()
                .encode()
                .toUri();
        HttpEntity entity = createEntity();

        when(restTemplate.exchange(url, HttpMethod.GET, entity, TraccarGeofenceDto[].class)).thenReturn(responseEntity);

        // When
        List<TraccarGeofenceDto> fetchedTraccarGeofences = traccarClient.getTraccarGeofences();

        // Then
        assertEquals(1, fetchedTraccarGeofences.size());
        assertEquals(0, fetchedTraccarGeofences.get(0).getId());
        assertEquals("nazwa", fetchedTraccarGeofences.get(0).getName());
    }

    @Test
    public void shouldFetchTraccarCalendars() {
        // Given
        when(traccarConfig.getTraccarApiEndpoint()).thenReturn("http://test.com");
        when(traccarConfig.getTraccarAuthorization()).thenReturn("test");

        TraccarCalendarDto[] traccarCalendarDtos = new TraccarCalendarDto[1];
        traccarCalendarDtos[0] = new TraccarCalendarDto(0L, "kalendarz 1", "ciąg znaków");
        ResponseEntity<TraccarCalendarDto[]> responseEntity = new ResponseEntity<TraccarCalendarDto[]>(
                traccarCalendarDtos,
                HttpStatus.OK
        );

        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/calendars")
                .build()
                .encode()
                .toUri();
        HttpEntity entity = createEntity();

        when(restTemplate.exchange(url, HttpMethod.GET, entity, TraccarCalendarDto[].class)).thenReturn(responseEntity);

        // When
        List<TraccarCalendarDto> fetchedTraccarCalendars = traccarClient.getTraccarCalendars();

        // Then
        assertEquals(1, fetchedTraccarCalendars.size());
        assertEquals(0, fetchedTraccarCalendars.get(0).getId());
        assertEquals("kalendarz 1", fetchedTraccarCalendars.get(0).getName());
    }

    @Test
    public void shouldFetchTraccarCommands() {
        // Given
        when(traccarConfig.getTraccarApiEndpoint()).thenReturn("http://test.com");
        when(traccarConfig.getTraccarAuthorization()).thenReturn("test");

        TraccarCommandDto[] traccarCommandDtos = new TraccarCommandDto[1];
        traccarCommandDtos[0] = new TraccarCommandDto(0L, 450L, "opis1", "typ1");
        ResponseEntity<TraccarCommandDto[]> responseEntity = new ResponseEntity<TraccarCommandDto[]>(
                traccarCommandDtos,
                HttpStatus.OK
        );

        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/commands")
                .build()
                .encode()
                .toUri();
        HttpEntity entity = createEntity();

        when(restTemplate.exchange(url, HttpMethod.GET, entity, TraccarCommandDto[].class)).thenReturn(responseEntity);

        // When
        List<TraccarCommandDto> fetchedTraccarCommands = traccarClient.getTraccarCommands();

        // Then
        assertEquals(1, fetchedTraccarCommands.size());
        assertEquals(0, fetchedTraccarCommands.get(0).getId());
        assertEquals("opis1", fetchedTraccarCommands.get(0).getDescription());
    }

    @Test
    public void shouldFetchTraccarDrivers() {
        // Given
        when(traccarConfig.getTraccarApiEndpoint()).thenReturn("http://test.com");
        when(traccarConfig.getTraccarAuthorization()).thenReturn("test");

        TraccarDriverDto[] traccarDriverDtos = new TraccarDriverDto[1];
        traccarDriverDtos[0] = new TraccarDriverDto(0L, "Zenek", "123");
        ResponseEntity<TraccarDriverDto[]> responseEntity = new ResponseEntity<TraccarDriverDto[]>(
                traccarDriverDtos,
                HttpStatus.OK
        );

        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/drivers")
                .build()
                .encode()
                .toUri();
        HttpEntity entity = createEntity();

        when(restTemplate.exchange(url, HttpMethod.GET, entity, TraccarDriverDto[].class)).thenReturn(responseEntity);

        // When
        List<TraccarDriverDto> fetchedTraccarDrivers = traccarClient.getTraccarDrivers();

        // Then
        assertEquals(1, fetchedTraccarDrivers.size());
        assertEquals(0, fetchedTraccarDrivers.get(0).getId());
        assertEquals("Zenek", fetchedTraccarDrivers.get(0).getName());
    }
}
