package com.autosledz.backend.domain.traccar;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TraccarGroup {
    private Long id;
    private String name;
    private Long groupId;
}
