package com.autosledz.backend.domain.traccar;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TraccarNotification {
    private Long id;
    private String type;
    private boolean always;
    private boolean web;
    private boolean mail;
    private boolean sms;
}
