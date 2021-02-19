package com.autosledz.backend.mapper;

import com.autosledz.backend.domain.Device;
import com.autosledz.backend.domain.DeviceDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutosledzMapper {
    public Device mapToDevice(final DeviceDto deviceDto) {
        return new Device (
                deviceDto.getId(),
                deviceDto.getName(),
                deviceDto.getLatitude(),
                deviceDto.getLongitude()
        );
    }

    public DeviceDto mapToDeviceDto(final Device device) {
        return new DeviceDto (
                device.getId(),
                device.getName(),
                device.getLatitude(),
                device.getLongitude()
        );
    }

    public List<DeviceDto> mapToDeviceDto(final List<Device> deviceList) {
        return deviceList.stream()
                .map(this::mapToDeviceDto)
                .collect(Collectors.toList());
    }
}
