package com.autosledz.backend.service;

import com.autosledz.backend.domain.traccar.TraccarDeviceDto;
import com.autosledz.backend.domain.traccar.TraccarPositionDto;
import com.autosledz.backend.domain.traccar.TraccarUserDto;
import com.autosledz.backend.traccar.client.TraccarClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TraccarService {
    private final TraccarClient traccarClient;

    public List<TraccarDeviceDto> fetchTraccarDevices() { return traccarClient.getTraccarDevices(); }

    public List<TraccarUserDto> fetchTraccarUsers() { return traccarClient.getTraccarUsers(); }

    public List<TraccarPositionDto> fetchTraccarPositions() { return traccarClient.getTraccarPositions(); }
}
