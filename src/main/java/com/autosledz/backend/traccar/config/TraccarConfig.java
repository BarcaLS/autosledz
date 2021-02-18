package com.autosledz.backend.traccar.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class TraccarConfig {
    @Value("${traccar.api.endpoint.prod}")
    private String traccarApiEndpoint;
    @Value("${traccar.authorization}")
    private String traccarAuthorization;
}
