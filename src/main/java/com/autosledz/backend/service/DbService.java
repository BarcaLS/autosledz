package com.autosledz.backend.service;

import com.autosledz.backend.domain.Device;
import com.autosledz.backend.domain.Endpoint;
import com.autosledz.backend.repository.DeviceRepository;
import com.autosledz.backend.repository.EndpointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {
    private final DeviceRepository deviceRepository;
    private final EndpointRepository endpointRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Optional<Device> getDevice(Long deviceId) { return deviceRepository.findById(deviceId); }

    public Device saveDevice(final Device device) { return deviceRepository.save(device); }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    public List<Endpoint> getAllEndpoints() {
        return endpointRepository.findAll();
    }

    public Endpoint saveEndpoint(final Endpoint endpoint) { return endpointRepository.save(endpoint); }

    public void deleteAllEndpoints() {
        endpointRepository.deleteAll();
    }
}
