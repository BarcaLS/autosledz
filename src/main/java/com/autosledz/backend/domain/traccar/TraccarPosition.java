package com.autosledz.backend.domain.traccar;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TraccarPosition {
    private Long id;
    private Long deviceId;
    private Float latitude;
    private Float longitude;
}
