package com.autosledz.backend.controller;

import com.autosledz.backend.domain.DeviceDto;
import com.autosledz.backend.domain.traccar.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(TraccarController.class)
public class TraccarControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TraccarController traccarController;

    @Test
    void getTraccarDevices() throws Exception {
        // Given
        List<TraccarDeviceDto> traccarDeviceDtos = new ArrayList<>();
        TraccarDeviceDto traccarDeviceDto1 = new TraccarDeviceDto(0L, "Ford", "Mondeo", "sedan");
        TraccarDeviceDto traccarDeviceDto2 = new TraccarDeviceDto(1L, "Opel", "Astra", "hatchback");
        traccarDeviceDtos.add(traccarDeviceDto1);
        traccarDeviceDtos.add(traccarDeviceDto2);
        when(traccarController.getTraccarDevices()).thenReturn(traccarDeviceDtos);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/traccar/devices")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("Ford")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].uniqueId", Matchers.is("Mondeo")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].category", Matchers.is("sedan")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("Opel")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].uniqueId", Matchers.is("Astra")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].category", Matchers.is("hatchback")));
    }

    @Test
    void getTraccarUsers() throws Exception {
        // Given
        List<TraccarUserDto> traccarUserDtos = new ArrayList<>();
        TraccarUserDto traccarUserDto1 = new TraccarUserDto(0L, "John", "john@smith.com", true);
        TraccarUserDto traccarUserDto2 = new TraccarUserDto(1L, "Zbyszek", "zbych@buziaczek.pl", false);
        traccarUserDtos.add(traccarUserDto1);
        traccarUserDtos.add(traccarUserDto2);
        when(traccarController.getTraccarUsers()).thenReturn(traccarUserDtos);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/traccar/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("John")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email", Matchers.is("john@smith.com")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].administrator", Matchers.is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("Zbyszek")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].email", Matchers.is("zbych@buziaczek.pl")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].administrator", Matchers.is(false)));
    }

    @Test
    void getTraccarPositions() throws Exception {
        // Given
        List<TraccarPositionDto> traccarPositionDtos = new ArrayList<>();
        TraccarPositionDto traccarPositionDto1 = new TraccarPositionDto(0L, 5L, 50.234F, 19.233F);
        TraccarPositionDto traccarPositionDto2 = new TraccarPositionDto(1L, 4L, 48.583F, 16.087F);
        traccarPositionDtos.add(traccarPositionDto1);
        traccarPositionDtos.add(traccarPositionDto2);
        when(traccarController.getTraccarPositions()).thenReturn(traccarPositionDtos);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/traccar/positions")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].deviceId", Matchers.is(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].latitude", Matchers.is(50.234)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].longitude", Matchers.is(19.233)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].deviceId", Matchers.is(4)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].latitude", Matchers.is(48.583)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].longitude", Matchers.is(16.087)));
    }

    @Test
    void getTraccarServer() throws Exception {
        // Given
        TraccarServerDto traccarServerDto = new TraccarServerDto(0L, "http://maps.google.com", 12, "4.12", 0.5F, 1.2F);
        when(traccarController.getTraccarServer()).thenReturn(traccarServerDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/traccar/server")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mapUrl", Matchers.is("http://maps.google.com")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.zoom", Matchers.is(12)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.version", Matchers.is("4.12")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cpuUsage", Matchers.is(0.5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.diskUsage", Matchers.is(1.2)));
    }

    @Test
    void getTraccarGroups() throws Exception {
        // Given
        List<TraccarGroupDto> traccarGroupDtos = new ArrayList<>();
        TraccarGroupDto traccarGroupDto1 = new TraccarGroupDto(0L, "grupa praca", 5L);
        TraccarGroupDto traccarGroupDto2 = new TraccarGroupDto(1L, "grupa dom", 6L);
        traccarGroupDtos.add(traccarGroupDto1);
        traccarGroupDtos.add(traccarGroupDto2);
        when(traccarController.getTraccarGroups()).thenReturn(traccarGroupDtos);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/traccar/groups")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("grupa praca")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].groupId", Matchers.is(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("grupa dom")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].groupId", Matchers.is(6)));
    }

    @Test
    void getTraccarNotifications() throws Exception {
        // Given
        List<TraccarNotificationDto> traccarNotificationDtos = new ArrayList<>();
        TraccarNotificationDto traccarNotificationDto1 = new TraccarNotificationDto(0L, "number 1", true, false, false, true);
        TraccarNotificationDto traccarNotificationDto2 = new TraccarNotificationDto(1L, "number 2", false, true, true, true);
        traccarNotificationDtos.add(traccarNotificationDto1);
        traccarNotificationDtos.add(traccarNotificationDto2);
        when(traccarController.getTraccarNotifications()).thenReturn(traccarNotificationDtos);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/traccar/notifications")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].type", Matchers.is("number 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].always", Matchers.is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].web", Matchers.is(false)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].mail", Matchers.is(false)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].sms", Matchers.is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].type", Matchers.is("number 2")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].always", Matchers.is(false)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].web", Matchers.is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].mail", Matchers.is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].sms", Matchers.is(true)));
    }

    @Test
    void getTraccarGeofences() throws Exception {
        // Given
        List<TraccarGeofenceDto> traccarGeofenceDtos = new ArrayList<>();
        TraccarGeofenceDto traccarGeofenceDto1 = new TraccarGeofenceDto(0L, "nazwa", "obszar");
        TraccarGeofenceDto traccarGeofenceDto2 = new TraccarGeofenceDto(1L, "inna nazwa", "inny obszar");
        traccarGeofenceDtos.add(traccarGeofenceDto1);
        traccarGeofenceDtos.add(traccarGeofenceDto2);
        when(traccarController.getTraccarGeofences()).thenReturn(traccarGeofenceDtos);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/traccar/geofences")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("nazwa")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].area", Matchers.is("obszar")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("inna nazwa")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].area", Matchers.is("inny obszar")));
    }

    @Test
    void getTraccarCalendars() throws Exception {
        // Given
        List<TraccarCalendarDto> traccarCalendarDtos = new ArrayList<>();
        TraccarCalendarDto traccarCalendarDto1 = new TraccarCalendarDto(0L, "kalendarz 1", "ciąg znaków");
        TraccarCalendarDto traccarCalendarDto2 = new TraccarCalendarDto(1L, "kalendarz 2", "jakiś inny ciąg znaków");
        traccarCalendarDtos.add(traccarCalendarDto1);
        traccarCalendarDtos.add(traccarCalendarDto2);
        when(traccarController.getTraccarCalendars()).thenReturn(traccarCalendarDtos);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/traccar/calendars")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("kalendarz 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].date", Matchers.is("ciąg znaków")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("kalendarz 2")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].date", Matchers.is("jakiś inny ciąg znaków")));
    }

    @Test
    void getTraccarCommands() throws Exception {
        // Given
        List<TraccarCommandDto> traccarCommandDtos = new ArrayList<>();
        TraccarCommandDto traccarCommandDto1 = new TraccarCommandDto(0L, 450L, "opis1", "typ1");
        TraccarCommandDto traccarCommandDto2 = new TraccarCommandDto(1L, 230L, "opis2", "typ2");
        traccarCommandDtos.add(traccarCommandDto1);
        traccarCommandDtos.add(traccarCommandDto2);
        when(traccarController.getTraccarCommands()).thenReturn(traccarCommandDtos);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/traccar/commands")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].deviceId", Matchers.is(450)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description", Matchers.is("opis1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].type", Matchers.is("typ1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].deviceId", Matchers.is(230)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].description", Matchers.is("opis2")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].type", Matchers.is("typ2")));
    }

    @Test
    void getTraccarDrivers() throws Exception {
        // Given
        List<TraccarDriverDto> traccarDriverDtos = new ArrayList<>();
        TraccarDriverDto traccarCommandDto1 = new TraccarDriverDto(0L, "Zenek", "123");
        TraccarDriverDto traccarCommandDto2 = new TraccarDriverDto(1L, "Bogdan", "456");
        traccarDriverDtos.add(traccarCommandDto1);
        traccarDriverDtos.add(traccarCommandDto2);
        when(traccarController.getTraccarDrivers()).thenReturn(traccarDriverDtos);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/traccar/drivers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("Zenek")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].uniqueId", Matchers.is("123")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("Bogdan")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].uniqueId", Matchers.is("456")));
    }
}
