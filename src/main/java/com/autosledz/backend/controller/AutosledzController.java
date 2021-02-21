package com.autosledz.backend.controller;

import com.autosledz.backend.domain.*;
import com.autosledz.backend.domain.traccar.TraccarPositionDto;
import com.autosledz.backend.mapper.AutosledzMapper;
import com.autosledz.backend.service.DbService;
import com.autosledz.backend.service.GeocodingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AutosledzController {
    private final DbService service;
    private final GeocodingService geocodingService;
    private final AutosledzMapper autosledzMapper;
    private final TraccarController traccarController;

    @RequestMapping(method = RequestMethod.GET, value = "/devices")
    public List<DeviceDto> getDevices() {
        service.saveEndpoint(new Endpoint("/v1/devices", "GET"));
        return autosledzMapper.mapToDeviceDto(service.getAllDevices());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/devices/{deviceId}")
    public DeviceDto getDevice(@PathVariable Long deviceId) throws DeviceNotFoundException {
        service.saveEndpoint(new Endpoint("/v1/devices/" + deviceId, "GET"));
        return autosledzMapper.mapToDeviceDto(service.getDevice(deviceId).orElseThrow(DeviceNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/devices", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createDevice(@RequestBody DeviceDto deviceDto) {
        service.saveEndpoint(new Endpoint("/v1/devices", "POST"));
        service.saveDevice(autosledzMapper.mapToDevice(deviceDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/devices")
    public DeviceDto updateDevice(@RequestBody DeviceDto deviceDto) {
        service.saveEndpoint(new Endpoint("/v1/devices", "PUT"));
        return autosledzMapper.mapToDeviceDto(service.saveDevice(autosledzMapper.mapToDevice(deviceDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/devices/{deviceId}/updatePosition")
    public DeviceDto updatePositionOfDevice(@PathVariable Long deviceId) throws DeviceNotFoundException {
        service.saveEndpoint(new Endpoint("/v1/devices/" + deviceId + "/updatePosition", "GET"));
        List<TraccarPositionDto> listOfPositions = traccarController.getTraccarPositions();
        for(TraccarPositionDto currentPosition : listOfPositions) {
            Optional<Device> device = service.getDevice(deviceId);
            if(currentPosition.getDeviceId() == Long.parseLong(device.get().getUniqueId())) {
                Float currentPositionLatitude = currentPosition.getLatitude();
                Float currentPositionLongitude = currentPosition.getLongitude();
                GeocodingDto currentPositionGeocoding = geocodingService.getGeocoding(currentPositionLatitude, currentPositionLongitude);;
                if(device.isPresent()) {
                    DeviceDto deviceWithUpdatedPosition = new DeviceDto(deviceId, service.getDevice(deviceId).get().getName(), device.get().getUniqueId(), currentPositionLatitude, currentPositionLongitude, currentPositionGeocoding.getDisplayName(), service.getDevice(deviceId).get().getCreated(), new Date());
                    service.saveDevice(autosledzMapper.mapToDevice(deviceWithUpdatedPosition));
                    return deviceWithUpdatedPosition;
                }
            }
        }
        throw new DeviceNotFoundException();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/devices/{deviceId}")
    public void deleteDevice(@PathVariable Long deviceId) {
        service.saveEndpoint(new Endpoint("/v1/devices/" + deviceId, "DELETE"));
        service.deleteDevice(deviceId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logs")
    public List<EndpointDto> getLogs() {
        service.saveEndpoint(new Endpoint("/v1/logs", "GET"));
        return autosledzMapper.mapToEndpointDto(service.getAllEndpoints());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logs/deleteAll")
    public void deleteLogs() {
        service.saveEndpoint(new Endpoint("/v1/logs/deleteAll", "GET"));
        service.deleteAllEndpoints();
    }
}
