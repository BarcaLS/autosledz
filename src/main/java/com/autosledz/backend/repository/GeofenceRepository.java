package com.autosledz.backend.repository;

import com.autosledz.backend.domain.Geofence;
import com.autosledz.backend.domain.GeofenceDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeofenceRepository extends CrudRepository<Geofence, Long> {
    List<Geofence> findAll();
    Optional<Geofence> findById(Long id);
    Geofence save(GeofenceDto geofence);
    void deleteById(Long id);
    void deleteAll();
}
