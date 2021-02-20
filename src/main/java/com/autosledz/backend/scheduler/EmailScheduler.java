package com.autosledz.backend.scheduler;

import com.autosledz.backend.config.AutosledzConfiguration;
import com.autosledz.backend.controller.AutosledzController;
import com.autosledz.backend.controller.DeviceNotFoundException;
import com.autosledz.backend.domain.DeviceDto;
import com.autosledz.backend.domain.Mail;
import com.autosledz.backend.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {
    private static final String SUBJECT = "New message from Autosledz";
    private final SimpleEmailService simpleEmailService;
    private final AutosledzConfiguration autosledzConfiguration;
    private final AutosledzController autosledzController;

    @Scheduled(cron = "0 0 23 * * *")
    public void sendInformationEmail() throws DeviceNotFoundException {
        DeviceDto deviceDto = autosledzController.updatePositionOfDevice(autosledzConfiguration.getDeviceIdToScheduledInform());
        String message = "Device " + deviceDto.getName() + " is at " + deviceDto.getDisplayName() + " (position updated: " + deviceDto.getUpdated() + ").";
        Mail mail = new Mail.MailBuilder()
                .subject(SUBJECT)
                .message(message)
                .mailTo(autosledzConfiguration.getAdminMail())
                .mailTo("someothermail@imaginedserver.com")
                .build();
        simpleEmailService.send(mail);
    }
}
