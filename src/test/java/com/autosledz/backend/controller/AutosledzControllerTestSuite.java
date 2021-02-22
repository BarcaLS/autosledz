package com.autosledz.backend.controller;

import com.autosledz.backend.domain.DeviceDto;
import com.autosledz.backend.domain.EndpointDto;
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
@WebMvcTest(AutosledzController.class)
public class AutosledzControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AutosledzController autosledzController;

    DateFormat df = new SimpleDateFormat("MM-dd-yyyy");

    @Test
    void getDevices() throws Exception {
        // Given
        List<DeviceDto> deviceDtos = new ArrayList<>();
        DeviceDto deviceDto1 = new DeviceDto(0L, "takietam", "oznaczenie", 50.450F, 12.405F, "urzadzenie_jakies", df.parse("2-11-2004"), df.parse("12-10-2011"));
        DeviceDto deviceDto2 = new DeviceDto(2L, "jakasnazwa", "tu ma być uniqueid", 45.058F, 19.310F, "moje urzadzenie", df.parse("12-05-2002"), df.parse("11-07-2019"));
        deviceDtos.add(deviceDto1);
        deviceDtos.add(deviceDto2);
        when(autosledzController.getDevices()).thenReturn(deviceDtos);

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
        when(autosledzController.getDevice(0L)).thenReturn(deviceDto);

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

    /*@Test
    void createDevice() throws Exception {
        // Given
        DeviceDto deviceDto = new DeviceDto(0L, "takietam", "oznaczenie", 50.450F, 12.405F, "urzadzenie_jakies", df.parse("2-11-2004"), df.parse("12-10-2011"));
        doNothing().when(autosledzController).createDevice(deviceDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(deviceDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/devices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent));
        verify(autosledzController, times(1)).createDevice(any());
    }*/

    /*@Test
    void updateDevice() throws Exception {
        // Given
        DeviceDto inputDeviceDto = new DeviceDto(0L, "takietam", "oznaczenie", 50.450F, 12.405F, "urzadzenie_jakies", df.parse("2-11-2004"), df.parse("12-10-2011"));
        DeviceDto outputDeviceDto = new DeviceDto(2L, "jakasnazwa", "tu ma być uniqueid", 45.058F, 19.310F, "moje urzadzenie", df.parse("12-05-2002"), df.parse("11-07-2019"));
        when(autosledzController.updateDevice(any(DeviceDto.class))).thenReturn(outputDeviceDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(inputDeviceDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/devices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("jakasnazwa")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.uniqueId", Matchers.is("tu ma być uniqueid")));
    }*/

    @Test
    void updatePositionOfDevice() throws Exception {
        // Given
        DeviceDto deviceDto = new DeviceDto(0L, "takietam", "oznaczenie", 50.450F, 12.405F, "urzadzenie_jakies", df.parse("2-11-2004"), df.parse("12-10-2011"));
        when(autosledzController.updatePositionOfDevice(0L)).thenReturn(deviceDto);

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
        doNothing().when(autosledzController).deleteDevice(0L);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/v1/devices/0")
                        .contentType(MediaType.APPLICATION_JSON));
        verify(autosledzController, times(1)).deleteDevice(0L);
    }

    @Test
    void deleteDevices() throws Exception {
        // Given
        doNothing().when(autosledzController).deleteDevices();

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/devices/deleteAll")
                        .contentType(MediaType.APPLICATION_JSON));
        verify(autosledzController, times(1)).deleteDevices();
    }

    @Test
    void getLogs() throws Exception {
        // Given
        List<EndpointDto> endpointDtos = new ArrayList<>();
        EndpointDto endpointDto1 = new EndpointDto(5L, "/v1/devices", "GET", df.parse("12-10-2011"));
        EndpointDto endpointDto2 = new EndpointDto(12L, "/v1/logs/deleteAll", "DELETE", df.parse("10-04-2015"));
        endpointDtos.add(endpointDto1);
        endpointDtos.add(endpointDto2);
        when(autosledzController.getLogs()).thenReturn(endpointDtos);

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
        doNothing().when(autosledzController).deleteLogs();

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/logs/deleteAll")
                        .contentType(MediaType.APPLICATION_JSON));
        verify(autosledzController, times(1)).deleteLogs();
    }
}
