package com.autosledz.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TraccarPosition {
    private Long id;
    private Long deviceId;
    private Long latitude;
    private Long longitude;
}
