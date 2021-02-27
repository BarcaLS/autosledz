package com.autosledz.backend.controller;

import com.autosledz.backend.domain.*;
import com.autosledz.backend.mapper.CarTrackMapper;
import com.autosledz.backend.service.CarTrackService;
import com.autosledz.backend.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CarTrackController {
    private final DbService service;
    private final CarTrackService carTrackService;
    private final CarTrackMapper carTrackMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/devices")
    public List<DeviceDto> getDevices() {
        service.saveEndpoint(new Endpoint("/v1/devices", "GET"));
        return carTrackMapper.mapToDeviceDto(service.getAllDevices());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/devices/{deviceId}")
    public DeviceDto getDevice(@PathVariable Long deviceId) throws DeviceNotFoundException {
        service.saveEndpoint(new Endpoint("/v1/devices/" + deviceId, "GET"));
        return carTrackMapper.mapToDeviceDto(service.getDevice(deviceId).orElseThrow(DeviceNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/devices", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createDevice(@RequestBody DeviceDto deviceDto) {
        service.saveEndpoint(new Endpoint("/v1/devices", "POST"));
        service.saveDevice(carTrackMapper.mapToDevice(deviceDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/devices")
    public DeviceDto updateDevice(@RequestBody DeviceDto deviceDto) {
        service.saveEndpoint(new Endpoint("/v1/devices", "PUT"));
        return carTrackMapper.mapToDeviceDto(service.saveDevice(carTrackMapper.mapToDevice(deviceDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/devices/{deviceId}/updatePosition")
    public DeviceDto updatePositionOfDevice(@PathVariable Long deviceId) throws DeviceNotFoundException {
        service.saveEndpoint(new Endpoint("/v1/devices/" + deviceId + "/updatePosition", "GET"));
        return carTrackService.updatePositionOfDevice(deviceId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/devices/{deviceId}")
    public void deleteDevice(@PathVariable Long deviceId) {
        service.saveEndpoint(new Endpoint("/v1/devices/" + deviceId, "DELETE"));
        service.deleteDevice(deviceId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/devices/deleteAll")
    public void deleteDevices() {
        service.saveEndpoint(new Endpoint("/v1/devices/deleteAll", "GET"));
        service.deleteAllDevices();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logs")
    public List<EndpointDto> getLogs() {
        service.saveEndpoint(new Endpoint("/v1/logs", "GET"));
        return carTrackMapper.mapToEndpointDto(service.getAllEndpoints());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logs/deleteAll")
    public void deleteLogs() {
        service.saveEndpoint(new Endpoint("/v1/logs/deleteAll", "GET"));
        service.deleteAllEndpoints();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/geofences")
    public List<GeofenceDto> getGeofences() {
        service.saveEndpoint(new Endpoint("/v1/geofences", "GET"));
        return carTrackMapper.mapToGeofenceDto(service.getAllGeofences());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/geofences/{geofenceId}")
    public GeofenceDto getGeofence(@PathVariable Long geofenceId) throws GeofenceNotFoundException {
        service.saveEndpoint(new Endpoint("/v1/geofences/" + geofenceId, "GET"));
        return carTrackMapper.mapToGeofenceDto(service.getGeofence(geofenceId).orElseThrow(GeofenceNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/geofences", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGeofence(@RequestBody GeofenceDto geofenceDto) {
        service.saveEndpoint(new Endpoint("/v1/geofences", "POST"));
        service.saveGeofence(carTrackMapper.mapToGeofence(geofenceDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/geofences")
    public GeofenceDto updateGeofence(@RequestBody GeofenceDto geofenceDto) {
        service.saveEndpoint(new Endpoint("/v1/geofences", "PUT"));
        return carTrackMapper.mapToGeofenceDto(service.saveGeofence(carTrackMapper.mapToGeofence(geofenceDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/geofences/{geofenceId}")
    public void deleteGeofence(@PathVariable Long geofenceId) {
        service.saveEndpoint(new Endpoint("/v1/geofences/" + geofenceId, "DELETE"));
        service.deleteGeofence(geofenceId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/geofences/deleteAll")
    public void deleteGeofences() {
        service.saveEndpoint(new Endpoint("/v1/geofences/deleteAll", "GET"));
        service.deleteAllGeofences();
    }
}
