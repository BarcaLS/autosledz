package com.autosledz.backend.service;

import com.autosledz.backend.domain.Mail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void shouldSendEmail() {
        //Given
        Mail mail = new Mail.MailBuilder()
                .subject("subject")
                .message("Test message")
                .mailTo("recipient@remoteserver.com")
                .mailTo("anotherrecipient@imaginedserver.com")
                .build();

        //When
        simpleEmailService.send(mail);

        //Then
        verify(javaMailSender, times(1)).send((MimeMessagePreparator) any());
    }
}
