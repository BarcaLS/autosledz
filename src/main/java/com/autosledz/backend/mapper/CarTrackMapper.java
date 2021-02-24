package com.autosledz.backend.mapper;

import com.autosledz.backend.domain.Device;
import com.autosledz.backend.domain.DeviceDto;
import com.autosledz.backend.domain.Endpoint;
import com.autosledz.backend.domain.EndpointDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarTrackMapper {
    public Device mapToDevice(final DeviceDto deviceDto) {
        return new Device (
                deviceDto.getId(),
                deviceDto.getName(),
                deviceDto.getUniqueId(),
                deviceDto.getLatitude(),
                deviceDto.getLongitude(),
                deviceDto.getDisplayName(),
                deviceDto.getCreated(),
                deviceDto.getUpdated()
        );
    }

    public DeviceDto mapToDeviceDto(final Device device) {
        return new DeviceDto (
                device.getId(),
                device.getName(),
                device.getUniqueId(),
                device.getLatitude(),
                device.getLongitude(),
                device.getDisplayName(),
                device.getCreated(),
                device.getUpdated()
        );
    }

    public List<DeviceDto> mapToDeviceDto(final List<Device> deviceList) {
        return deviceList.stream()
                .map(this::mapToDeviceDto)
                .collect(Collectors.toList());
    }

    public EndpointDto mapToEndpointDto(final Endpoint endpoint) {
        return new EndpointDto(
                endpoint.getId(),
                endpoint.getEndpoint(),
                endpoint.getMethod(),
                endpoint.getVisited()
        );
    }

    public List<EndpointDto> mapToEndpointDto(final List<Endpoint> endpointList) {
        return endpointList.stream()
                .map(this::mapToEndpointDto)
                .collect(Collectors.toList());
    }
}
