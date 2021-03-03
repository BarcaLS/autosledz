package com.autosledz.backend.service;

import com.autosledz.backend.controller.DeviceNotFoundException;
import com.autosledz.backend.controller.TraccarController;
import com.autosledz.backend.domain.DeviceDto;
import com.autosledz.backend.domain.GeocodingDto;
import com.autosledz.backend.domain.traccar.TraccarDeviceDto;
import com.autosledz.backend.domain.traccar.TraccarPositionDto;
import com.autosledz.backend.mapper.CarTrackMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CarTrackService {
    private final DbService service;
    private final TraccarController traccarController;
    private final GeocodingService geocodingService;
    private final CarTrackMapper carTrackMapper;

    public DeviceDto updatePositionOfDevice(Long deviceId) throws DeviceNotFoundException {
        List<TraccarPositionDto> listOfPositions = traccarController.getTraccarPositions();
        for(TraccarPositionDto currentPosition : listOfPositions) {
            List<TraccarDeviceDto> traccarDevices = traccarController.getTraccarDevices();
            List<TraccarDeviceDto> traccarDevice = traccarDevices.stream()
                    .filter(d -> d.getId() == deviceId)
                    .collect(Collectors.toList());
            if(currentPosition.getDeviceId().equals(traccarDevice.get(0).getId())) {
                Float currentPositionLatitude = currentPosition.getLatitude();
                Float currentPositionLongitude = currentPosition.getLongitude();
                GeocodingDto currentPositionGeocoding = geocodingService.getGeocoding(currentPositionLatitude, currentPositionLongitude);
                DeviceDto deviceWithUpdatedPosition = new DeviceDto(deviceId, service.getDevice(deviceId).get().getName(), service.getDevice(deviceId).get().getUniqueId(), currentPositionLatitude, currentPositionLongitude, currentPositionGeocoding.getDisplayName(), service.getDevice(deviceId).get().getCreated(), new Date());
                service.saveDevice(carTrackMapper.mapToDevice(deviceWithUpdatedPosition));
                return deviceWithUpdatedPosition;
            }
        }
        throw new DeviceNotFoundException();
    }
}
