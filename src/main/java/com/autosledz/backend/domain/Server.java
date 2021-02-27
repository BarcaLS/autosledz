package com.autosledz.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "servers")
public class Server {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "mapUrl")
    private String mapUrl;

    @Column(name = "zoom")
    private int zoom;

    @Column(name = "version")
    private String version;

    @Column (name = "cpuUsage")
    private Float cpuUsage;

    @Column (name = "diskUsage")
    private Float diskUsage;
}
