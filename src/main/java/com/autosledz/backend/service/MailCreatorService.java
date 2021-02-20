package com.autosledz.backend.service;

import com.autosledz.backend.config.AutosledzConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailCreatorService {
    @Autowired
    private AutosledzConfiguration autosledzConfiguration;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildCurrentPositionEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("admin_name", autosledzConfiguration.getAdminName());
        context.setVariable("admin_mail", autosledzConfiguration.getAdminMail());
        context.setVariable("app_name", autosledzConfiguration.getAppName());
        context.setVariable("mail_footer", autosledzConfiguration.getMailFooter());
        return templateEngine.process("mail/current-position-mail", context);
    }
}
