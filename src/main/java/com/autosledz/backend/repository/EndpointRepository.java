package com.autosledz.backend.repository;

import com.autosledz.backend.domain.Endpoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EndpointRepository extends CrudRepository<Endpoint, Long> {
    List<Endpoint> findAll();
    Endpoint save(Endpoint device);
    void deleteAll();
}
