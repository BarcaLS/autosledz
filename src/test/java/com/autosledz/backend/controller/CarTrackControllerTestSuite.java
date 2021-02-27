package com.autosledz.backend.controller;

import com.autosledz.backend.domain.*;
import com.google.gson.Gson;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringJUnitWebConfig
@WebMvcTest(CarTrackController.class)
public class CarTrackControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarTrackController carTrackController;

    DateFormat df = new SimpleDateFormat("MM-dd-yyyy");

    @Test
    void getDevices() throws Exception {
        // Given
        List<DeviceDto> deviceDtos = new ArrayList<>();
        DeviceDto deviceDto1 = new DeviceDto(0L, "takietam", "oznaczenie", 50.450F, 12.405F, "urzadzenie_jakies", df.parse("2-11-2004"), df.parse("12-10-2011"));
        DeviceDto deviceDto2 = new DeviceDto(2L, "jakasnazwa", "tu ma być uniqueid", 45.058F, 19.310F, "moje urzadzenie", df.parse("12-05-2002"), df.parse("11-07-2019"));
        deviceDtos.add(deviceDto1);
        deviceDtos.add(deviceDto2);
        when(carTrackController.getDevices()).thenReturn(deviceDtos);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/devices")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("takietam")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].uniqueId", Matchers.is("oznaczenie")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("jakasnazwa")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].uniqueId", Matchers.is("tu ma być uniqueid")));
    }

    @Test
    void getDevice() throws Exception {
        // Given
        DeviceDto deviceDto = new DeviceDto(0L, "takietam", "oznaczenie", 50.450F, 12.405F, "urzadzenie_jakies", df.parse("2-11-2004"), df.parse("12-10-2011"));
        Device device = new Device(0L, "takietam", "oznaczenie", 50.450F, 12.405F, "urzadzenie_jakies", df.parse("2-11-2004"), df.parse("12-10-2011"));
        when(carTrackController.getDevice(any())).thenReturn(deviceDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/devices/0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("takietam")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.uniqueId", Matchers.is("oznaczenie")));
    }

    @Test
    void createDevice() throws Exception {
        // Given
        DeviceDto deviceDto = new DeviceDto(0L, "takietam", "oznaczenie", 50.450F, 12.405F, "urzadzenie_jakies", df.parse("2-11-2004"), df.parse("12-10-2011"));
        doNothing().when(carTrackController).createDevice(deviceDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(deviceDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/devices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent));
    }

    @Test
    void updatePositionOfDevice() throws Exception {
        // Given
        DeviceDto deviceDto = new DeviceDto(0L, "takietam", "oznaczenie", 50.450F, 12.405F, "urzadzenie_jakies", df.parse("2-11-2004"), df.parse("12-10-2011"));
        when(carTrackController.updatePositionOfDevice(0L)).thenReturn(deviceDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/devices/0/updatePosition")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("takietam")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.uniqueId", Matchers.is("oznaczenie")));
    }

    @Test
    void deleteDevice() throws Exception {
        // Given
        doNothing().when(carTrackController).deleteDevice(0L);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/v1/devices/0")
                        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void deleteDevices() throws Exception {
        // Given
        doNothing().when(carTrackController).deleteDevices();

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/devices/deleteAll")
                        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getLogs() throws Exception {
        // Given
        List<EndpointDto> endpointDtos = new ArrayList<>();
        EndpointDto endpointDto1 = new EndpointDto(5L, "/v1/devices", "GET", df.parse("12-10-2011"));
        EndpointDto endpointDto2 = new EndpointDto(12L, "/v1/logs/deleteAll", "DELETE", df.parse("10-04-2015"));
        endpointDtos.add(endpointDto1);
        endpointDtos.add(endpointDto2);
        when(carTrackController.getLogs()).thenReturn(endpointDtos);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/logs")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].endpoint", Matchers.is("/v1/devices")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].method", Matchers.is("GET")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(12)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].endpoint", Matchers.is("/v1/logs/deleteAll")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].method", Matchers.is("DELETE")));
    }

    @Test
    void deleteLogs() throws Exception {
        // Given
        doNothing().when(carTrackController).deleteLogs();

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/logs/deleteAll")
                        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getGeofences() throws Exception {
        // Given
        List<GeofenceDto> geofenceDtos = new ArrayList<>();
        GeofenceDto GeofenceDto1 = new GeofenceDto(0L, "takietam", "some_area");
        GeofenceDto GeofenceDto2 = new GeofenceDto(2L, "jakasnazwa", "other area");
        geofenceDtos.add(GeofenceDto1);
        geofenceDtos.add(GeofenceDto2);
        when(carTrackController.getGeofences()).thenReturn(geofenceDtos);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/geofences")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("takietam")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].area", Matchers.is("some_area")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("jakasnazwa")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].area", Matchers.is("other area")));
    }

    @Test
    void getGeofence() throws Exception {
        // Given
        GeofenceDto GeofenceDto = new GeofenceDto(0L, "takietam", "some_area");
        Geofence geofence = new Geofence(0L, "takietam", "some_area");
        when(carTrackController.getGeofence(any())).thenReturn(GeofenceDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/geofences/0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("takietam")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.area", Matchers.is("some_area")));
    }

    @Test
    void createGeofence() throws Exception {
        // Given
        GeofenceDto GeofenceDto = new GeofenceDto(0L, "takietam", "some_area");
        doNothing().when(carTrackController).createGeofence(GeofenceDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(GeofenceDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/geofences")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent));
    }

    @Test
    void deleteGeofence() throws Exception {
        // Given
        doNothing().when(carTrackController).deleteGeofence(0L);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/v1/geofences/0")
                        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void deleteGeofences() throws Exception {
        // Given
        doNothing().when(carTrackController).deleteGeofences();

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/geofences/deleteAll")
                        .contentType(MediaType.APPLICATION_JSON));
    }
}
