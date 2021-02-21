package com.autosledz.backend.repository;

import com.autosledz.backend.domain.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {
    List<Device> findAll();
    Optional<Device> findById(Long id);
    Device save(Device device);
    void deleteById(Long id);
    void deleteAll();
}
