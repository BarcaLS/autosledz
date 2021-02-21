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

    public TraccarServer mapToTraccarServer(final TraccarServerDto traccarServerDto) {
        return new TraccarServer(traccarServerDto.getId(), traccarServerDto.getMapUrl(), traccarServerDto.getZoom(), traccarServerDto.getVersion(), traccarServerDto.getCpuUsage(), traccarServerDto.getDiskUsage());
    }

    public TraccarServerDto mapToTraccarServerDto(final TraccarServer traccarServer) {
        return new TraccarServerDto(traccarServer.getId(), traccarServer.getMapUrl(), traccarServer.getZoom(), traccarServer.getVersion(), traccarServer.getCpuUsage(), traccarServer.getDiskUsage());
    }

    public List<TraccarGroup> mapToTraccarGroup(final List<TraccarGroupDto> traccarGroupDto) {
        return traccarGroupDto.stream()
                .map(traccarGroup ->
                        new TraccarGroup(traccarGroup.getId(), traccarGroup.getName(), traccarGroup.getGroupId()))
                .collect(toList());
    }

    public List<TraccarGroupDto> mapToTraccarGroupDto(final List<TraccarGroup> traccarGroups) {
        return traccarGroups.stream()
                .map(traccarGroup ->
                        new TraccarGroupDto(traccarGroup.getId(), traccarGroup.getName(), traccarGroup.getGroupId()))
                .collect(toList());
    }

    public List<TraccarNotification> mapToTraccarNotification(final List<TraccarNotificationDto> traccarNotificationDto) {
        return traccarNotificationDto.stream()
                .map(traccarNotification ->
                        new TraccarNotification(traccarNotification.getId(), traccarNotification.getType(), traccarNotification.isAlways(), traccarNotification.isWeb(), traccarNotification.isMail(), traccarNotification.isSms()))
                .collect(toList());
    }

    public List<TraccarNotificationDto> mapToTraccarNotificationDto(final List<TraccarNotification> traccarNotifications) {
        return traccarNotifications.stream()
                .map(traccarNotification ->
                        new TraccarNotificationDto(traccarNotification.getId(), traccarNotification.getType(), traccarNotification.isAlways(), traccarNotification.isWeb(), traccarNotification.isMail(), traccarNotification.isSms()))
                .collect(toList());
    }

    public List<TraccarGeofence> mapToTraccarGeofence(final List<TraccarGeofenceDto> traccarGeofenceDto) {
        return traccarGeofenceDto.stream()
                .map(traccarGeofence ->
                        new TraccarGeofence(traccarGeofence.getId(), traccarGeofence.getName(), traccarGeofence.getArea()))
                .collect(toList());
    }

    public List<TraccarGeofenceDto> mapToTraccarGeofenceDto(final List<TraccarGeofence> traccarGeofences) {
        return traccarGeofences.stream()
                .map(traccarGeofence ->
                        new TraccarGeofenceDto(traccarGeofence.getId(), traccarGeofence.getName(), traccarGeofence.getArea()))
                .collect(toList());
    }

    public List<TraccarCalendar> mapToTraccarCalendar(final List<TraccarCalendarDto> traccarCalendarDto) {
        return traccarCalendarDto.stream()
                .map(traccarCalendar ->
                        new TraccarCalendar(traccarCalendar.getId(), traccarCalendar.getName(), traccarCalendar.getDate()))
                .collect(toList());
    }

    public List<TraccarCalendarDto> mapToTraccarCalendarDto(final List<TraccarCalendar> traccarCalendars) {
        return traccarCalendars.stream()
                .map(traccarCalendar ->
                        new TraccarCalendarDto(traccarCalendar.getId(), traccarCalendar.getName(), traccarCalendar.getDate()))
                .collect(toList());
    }

    public List<TraccarCommand> mapToTraccarCommand(final List<TraccarCommandDto> traccarCommandDto) {
        return traccarCommandDto.stream()
                .map(traccarCommand ->
                        new TraccarCommand(traccarCommand.getId(), traccarCommand.getDeviceId(), traccarCommand.getDescription(), traccarCommand.getType()))
                .collect(toList());
    }

    public List<TraccarCommandDto> mapToTraccarCommandDto(final List<TraccarCommand> traccarCommands) {
        return traccarCommands.stream()
                .map(traccarCommand ->
                        new TraccarCommandDto(traccarCommand.getId(), traccarCommand.getDeviceId(), traccarCommand.getDescription(), traccarCommand.getType()))
                .collect(toList());
    }
}
