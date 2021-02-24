package com.autosledz.backend.service;

import com.autosledz.backend.config.CarTrackConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailCreatorService {
    @Autowired
    private CarTrackConfiguration carTrackConfiguration;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildCurrentPositionEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("admin_name", carTrackConfiguration.getAdminName());
        context.setVariable("admin_mail", carTrackConfiguration.getAdminMail());
        context.setVariable("app_name", carTrackConfiguration.getAppName());
        context.setVariable("mail_footer", carTrackConfiguration.getMailFooter());
        return templateEngine.process("mail/current-position-mail", context);
    }
}
