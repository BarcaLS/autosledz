package com.autosledz.backend.repository;

import com.autosledz.backend.domain.Server;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServerRepository extends CrudRepository<Server, Long> {
    List<Server> findAll();
    Optional<Server> findById(Long id);
    Server save(Server Server);
    void deleteById(Long id);
    void deleteAll();
}
