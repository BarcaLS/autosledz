package com.autosledz.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PositionDto {
    private Long id;
    private Long deviceId;
    private Long latitude;
    private Long longitude;
}
