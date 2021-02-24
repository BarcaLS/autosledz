package com.autosledz.backend.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@EnableScheduling
@Getter
@Component
public class CarTrackConfiguration {
    @Value("${admin.name}")
    private String adminName;

    @Value("${admin.mail}")
    private String adminMail;

    @Value("${app.name}")
    private String appName;

    @Value("${device.id.to.scheduled.inform}")
    private Long deviceIdToScheduledInform;

    @Value("${mail.footer}")
    private String mailFooter;

    @Value("${notification.mail}")
    private String notificationMail;
}
