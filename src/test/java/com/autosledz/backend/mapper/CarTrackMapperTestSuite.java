package com.autosledz.backend.mapper;

import com.autosledz.backend.domain.Device;
import com.autosledz.backend.domain.DeviceDto;
import com.autosledz.backend.domain.Endpoint;
import com.autosledz.backend.domain.EndpointDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CarTrackMapperTestSuite {
    @Autowired
    private CarTrackMapper carTrackMapper;

    DateFormat df = new SimpleDateFormat("MM-dd-yyyy");

    @Test
    public void mapToDevice() throws ParseException {
        // Given
        DeviceDto deviceDto = new DeviceDto(0L, "takietam", "oznaczenie", 50.450F, 12.405F, "urzadzenie_jakies", df.parse("2-11-2004"), df.parse("12-10-2011"));

        // When
        Device device = carTrackMapper.mapToDevice(deviceDto);

        // Then
        assertEquals("takietam", device.getName());
    }

    @Test
    public void mapToDeviceDto() throws ParseException {
        // Given
        Device device = new Device(0L, "takietam", "oznaczenie", 50.450F, 12.405F, "urzadzenie_jakies", df.parse("2-11-2004"), df.parse("12-10-2011"));

        // When
        DeviceDto deviceDto = carTrackMapper.mapToDeviceDto(device);

        // Then
        assertEquals("takietam", device.getName());
    }

    @Test
    public void mapToDeviceDtoReturnList() throws ParseException {
        // Given
        Device device1 = new Device(0L, "takietam", "oznaczenie1", 50.450F, 12.405F, "urzadzenie1", df.parse("2-11-2004"), df.parse("12-10-2011"));
        Device device2 = new Device(1L, "inne takietam", "oznaczenie2", 40.409F, 13.815F, "urzadzenie2", df.parse("12-5-2019"), df.parse("19-01-2020"));

        // When
        List<DeviceDto> deviceDtos = carTrackMapper.mapToDeviceDto(List.of(device1, device2));

        // Then
        assertEquals(2, deviceDtos.size());
    }

    @Test
    public void mapToEndpointDto() throws ParseException {
        // Given
        Endpoint endpoint = new Endpoint(5L, "/v1/devices", "GET", df.parse("12-10-2011"));

        // When
        EndpointDto endpointDto = carTrackMapper.mapToEndpointDto(endpoint);

        // Then
        assertEquals("/v1/devices", endpoint.getEndpoint());
    }

    @Test
    public void mapToEndpointDtoReturnList() throws ParseException {
        // Given
        Endpoint endpoint1 = new Endpoint(5L, "/v1/devices", "GET", df.parse("12-10-2011"));
        Endpoint endpoint2 = new Endpoint(12L, "/v1/logs/deleteAll", "DELETE", df.parse("10-04-2015"));

        // When
        List<EndpointDto> endpointDtos = carTrackMapper.mapToEndpointDto(List.of(endpoint1, endpoint2));

        // Then
        assertEquals(2, endpointDtos.size());
    }
}
