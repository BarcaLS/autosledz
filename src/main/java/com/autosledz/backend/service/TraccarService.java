package com.autosledz.backend.service;

import com.autosledz.backend.domain.TraccarDeviceDto;
import com.autosledz.backend.domain.TraccarPositionDto;
import com.autosledz.backend.domain.TraccarUserDto;
import com.autosledz.backend.traccar.client.TraccarClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TraccarService {
    private static final String SUBJECT = "Tasks: New Trello card";
    private final TraccarClient traccarClient;

    public List<TraccarDeviceDto> fetchTraccarDevices() { return traccarClient.getTraccarDevices(); }

    public List<TraccarUserDto> fetchTraccarUsers() { return traccarClient.getTraccarUsers(); }

    public List<TraccarPositionDto> fetchTraccarPositions() { return traccarClient.getTraccarPositions(); }
}
