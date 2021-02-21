package com.autosledz.backend.domain;

import com.autosledz.backend.service.DbService;
import com.autosledz.backend.service.TraccarService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "endpoints")
public class Endpoint {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "endpoint")
    private String endpoint;

    @Column(name = "method")
    private String method;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "visited", nullable = false)
    private Date visited;

    @PrePersist
    protected void onCreate() {
        visited = new Date();
    }

    public Endpoint(String endpoint, String method) {
        this.endpoint = endpoint;
        this.method = method;
    }
}
