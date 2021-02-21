package com.autosledz.backend.domain.traccar;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TraccarCommand {
    private Long id;
    private Long deviceId;
    private String description;
    private String type;
}
