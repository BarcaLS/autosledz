package com.autosledz.backend.service;

import com.autosledz.backend.domain.Device;
import com.autosledz.backend.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {
    private final DeviceRepository deviceRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    /*public Optional<Device> getDevice(Long id) {
        return deviceRepository.findById(id);
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    public Device saveDevice(final Device device) {
        return deviceRepository.save(device);
    }*/
}
