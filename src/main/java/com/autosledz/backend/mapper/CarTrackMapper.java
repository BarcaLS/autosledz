package com.autosledz.backend.mapper;

import com.autosledz.backend.domain.*;
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

    public Geofence mapToGeofence(final GeofenceDto geofenceDto) {
        return new Geofence (
                geofenceDto.getId(),
                geofenceDto.getName(),
                geofenceDto.getArea()
        );
    }

    public GeofenceDto mapToGeofenceDto(final Geofence geofence) {
        return new GeofenceDto (
                geofence.getId(),
                geofence.getName(),
                geofence.getArea()
        );
    }

    public List<GeofenceDto> mapToGeofenceDto(final List<Geofence> geofenceList) {
        return geofenceList.stream()
                .map(this::mapToGeofenceDto)
                .collect(Collectors.toList());
    }

    public Server mapToServer(final ServerDto ServerDto) {
        return new Server (
                ServerDto.getId(),
                ServerDto.getMapUrl(),
                ServerDto.getZoom(),
                ServerDto.getVersion(),
                ServerDto.getCpuUsage(),
                ServerDto.getDiskUsage()
        );
    }

    public ServerDto mapToServerDto(final Server Server) {
        return new ServerDto (
                Server.getId(),
                Server.getMapUrl(),
                Server.getZoom(),
                Server.getVersion(),
                Server.getCpuUsage(),
                Server.getDiskUsage()
        );
    }

    public List<ServerDto> mapToServerDto(final List<Server> ServerList) {
        return ServerList.stream()
                .map(this::mapToServerDto)
                .collect(Collectors.toList());
    }
}
