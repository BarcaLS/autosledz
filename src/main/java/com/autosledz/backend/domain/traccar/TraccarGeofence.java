package com.autosledz.backend.domain.traccar;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TraccarGeofence {
    private Long id;
    private String name;
    private String area;
}
