package com.autosledz.backend.domain.traccar;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TraccarServer {
    private Long id;
    private String mapUrl;
    private int zoom;
    private String version;
    private float cpuUsage;
    private float diskUsage;
}
