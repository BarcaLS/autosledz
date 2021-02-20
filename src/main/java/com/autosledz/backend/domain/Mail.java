package com.autosledz.backend.domain;

import java.util.ArrayList;
import java.util.List;

public class Mail {
    private final String subject;
    private final String message;
    private final List<String> mailTo;

    public static class MailBuilder {
        private String subject;
        private String message;
        private List<String> mailTo = new ArrayList<>();

        public MailBuilder subject(String subject) { this.subject = subject; return this; }
        public MailBuilder message(String message) { this.message = message; return this; }
        public MailBuilder mailTo(String recipient) { mailTo.add(recipient); return this; }
        public Mail build() { return new Mail(subject, message, mailTo); }
    }

    private Mail(final String subject, final String message, List<String> mailTo) {
        this.subject = subject;
        this.message = message;
        this.mailTo = new ArrayList<>(mailTo);
    }

    public String getSubject() { return subject; }
    public String getMessage() { return message; }
    public List<String> getMailTo() { return mailTo; }
}
