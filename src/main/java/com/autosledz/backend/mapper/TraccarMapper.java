package com.autosledz.backend.mapper;

import com.autosledz.backend.domain.traccar.*;
import org.springframework.stereotype.Component;
import static java.util.stream.Collectors.toList;

import java.util.List;

@Component
public class TraccarMapper {
    public List<TraccarDevice> mapToTraccarDevices(final List<TraccarDeviceDto> traccarDeviceDto) {
        return traccarDeviceDto.stream()
                .map(traccarDevice ->
                        new TraccarDevice(traccarDevice.getId(), traccarDevice.getName(), traccarDevice.getUniqueId(), traccarDevice.getCategory()))
                .collect(toList());
    }

    public List<TraccarDeviceDto> mapToTraccarDevicesDto(final List<TraccarDevice> traccarDevices) {
        return traccarDevices.stream()
                .map(traccarDevice ->
                        new TraccarDeviceDto(traccarDevice.getId(), traccarDevice.getName(), traccarDevice.getUniqueId(), traccarDevice.getCategory()))
                .collect(toList());
    }

    public List<TraccarUser> mapToTraccarUsers(final List<TraccarUserDto> traccarUserDto) {
        return traccarUserDto.stream()
                .map(traccarUser ->
                        new TraccarUser(traccarUser.getId(), traccarUser.getName(), traccarUser.getEmail(), traccarUser.isAdministrator()))
                .collect(toList());
    }

    public List<TraccarUserDto> mapToTraccarUsersDto(final List<TraccarUser> traccarUsers) {
        return traccarUsers.stream()
                .map(traccarUser ->
                        new TraccarUserDto(traccarUser.getId(), traccarUser.getName(), traccarUser.getEmail(), traccarUser.isAdministrator()))
                .collect(toList());
    }

    public List<TraccarPosition> mapToTraccarPositions(final List<TraccarPositionDto> traccarPositionDto) {
        return traccarPositionDto.stream()
                .map(traccarPosition ->
                        new TraccarPosition(traccarPosition.getId(), traccarPosition.getDeviceId(), traccarPosition.getLatitude(), traccarPosition.getLongitude()))
                .collect(toList());
    }

    public List<TraccarPositionDto> mapToTraccarPositionsDto(final List<TraccarPosition> traccarPositions) {
        return traccarPositions.stream()
                .map(traccarPosition ->
                        new TraccarPositionDto(traccarPosition.getId(), traccarPosition.getDeviceId(), traccarPosition.getLatitude(), traccarPosition.getLongitude()))
                .collect(toList());
    }
}
