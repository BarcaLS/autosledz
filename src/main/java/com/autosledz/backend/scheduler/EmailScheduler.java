package com.autosledz.backend.scheduler;

import com.autosledz.backend.config.CarTrackConfiguration;
import com.autosledz.backend.controller.CarTrackController;
import com.autosledz.backend.controller.DeviceNotFoundException;
import com.autosledz.backend.controller.TraccarController;
import com.autosledz.backend.domain.DeviceDto;
import com.autosledz.backend.domain.Mail;
import com.autosledz.backend.domain.traccar.TraccarDeviceDto;
import com.autosledz.backend.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmailScheduler {
    private static final String SUBJECT = "New message from Autosledz";
    private final SimpleEmailService simpleEmailService;
    private final CarTrackConfiguration carTrackConfiguration;
    private final CarTrackController carTrackController;
    private final TraccarController traccarController;

    @Scheduled(cron = "0 0 23 * * *")
    public void sendInformationEmail() throws DeviceNotFoundException {
        List<TraccarDeviceDto> traccarDevices = traccarController.getTraccarDevices();
        List<DeviceDto> devices = carTrackController.getDevices();

        List<TraccarDeviceDto> traccarDevice = traccarDevices.stream()
                .filter(d -> d.getName().equals(carTrackConfiguration.getDeviceNameToScheduledInform()))
                .collect(Collectors.toList());
        List<DeviceDto> device = devices.stream()
                .filter(d -> d.getName().equals(carTrackConfiguration.getDeviceNameToScheduledInform()))
                .collect(Collectors.toList());
        DeviceDto deviceDto = carTrackController.updatePositionOfDevice(traccarDevice.get(0).getId(), device.get(0).getId());
        String message = "Device " + deviceDto.getName() + " is at " + deviceDto.getDisplayName() + " (position updated: " + deviceDto.getUpdated() + ").";
        Mail mail = new Mail.MailBuilder()
                .subject(SUBJECT)
                .message(message)
                .mailTo(carTrackConfiguration.getAdminMail())
                .mailTo("someothermail@imaginedserver.com")
                .build();
        simpleEmailService.send(mail);
    }
}
