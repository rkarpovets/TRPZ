package com.emailclient.model;

import java.io.File;
import java.util.Date;

/**
 * Pattern: Builder
 */
public class EmailMessage {
    private final String recipient;
    private final String subject;
    private final String body;
    private final File attachment;
    private final Date sentDate;

    private EmailMessage(Builder builder) {
        this.recipient = builder.recipient;
        this.subject = builder.subject;
        this.body = builder.body;
        this.attachment = builder.attachment;
        this.sentDate = new Date();
    }

    public String getRecipient() { return recipient; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }
    public File getAttachment() { return attachment; }

    @Override
    public String toString() {
        return String.format("To: %s | Subject: %s", recipient, subject);
    }

    public static class Builder {
        private String recipient;
        private String subject;
        private String body = "";
        private File attachment;

        public Builder setRecipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setAttachment(File attachment) {
            this.attachment = attachment;
            return this;
        }

        public EmailMessage build() {
            if (recipient == null || recipient.isEmpty()) {
                throw new IllegalStateException("Recipient is required");
            }
            return new EmailMessage(this);
        }
    }
}