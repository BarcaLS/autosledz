package com.autosledz.backend.controller;

import com.autosledz.backend.domain.DeviceDto;
import com.autosledz.backend.mapper.AutosledzMapper;
import com.autosledz.backend.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AutosledzController {
    private final DbService service;
    private final AutosledzMapper autosledzMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/devices")
    public List<DeviceDto> getDevices() {
        return autosledzMapper.mapToDeviceDto(service.getAllDevices());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/devices/{deviceId}")
    public DeviceDto getDevice(@PathVariable Long deviceId) throws DeviceNotFoundException {
        return autosledzMapper.mapToDeviceDto(service.getDevice(deviceId).orElseThrow(DeviceNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/devices", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createDevice(@RequestBody DeviceDto deviceDto) {
        service.saveDevice(autosledzMapper.mapToDevice(deviceDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/devices")
    public DeviceDto updateDevice(@RequestBody DeviceDto deviceDto) {
        return autosledzMapper.mapToDeviceDto(service.saveDevice(autosledzMapper.mapToDevice(deviceDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/devices/{deviceId}")
    public void deleteTask(@PathVariable Long deviceId) {
        service.deleteDevice(deviceId);
    }
}
