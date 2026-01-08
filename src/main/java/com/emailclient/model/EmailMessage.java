package com.emailclient.model;

import java.io.File;
import java.time.LocalDateTime;

/**
 * Патерн: Builder.
 * Клас представляє електронний лист.
 * Використання Builder дозволяє створювати об'єкт покроково,
 * уникаючи конструкторів з великою кількістю параметрів.
 */
public class EmailMessage {
    // Всі поля final, щоб об'єкт був незмінним (Immutable)
    private final String recipient;    // Обов'язкове
    private final String subject;      // Обов'язкове
    private final String sender;       // Обов'язкове

    private final String body;         // Опціональне
    private final File attachment;     // Опціональне
    private final LocalDateTime timestamp; // Автоматичне

    // Приватний конструктор: об'єкт можна створити ТІЛЬКИ через Builder
    private EmailMessage(Builder builder) {
        this.recipient = builder.recipient;
        this.subject = builder.subject;
        this.sender = builder.sender;
        this.body = builder.body;
        this.attachment = builder.attachment;
        this.timestamp = LocalDateTime.now();
    }

    // Геттери (сетерів немає, бо об'єкт Immutable)
    public String getRecipient() { return recipient; }
    public String getSubject() { return subject; }
    public String getSender() { return sender; }
    public String getBody() { return body; }
    public File getAttachment() { return attachment; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "EmailMessage{" +
                "From='" + sender + '\'' +
                ", To='" + recipient + '\'' +
                ", Subject='" + subject + '\'' +
                ", HasAttachment=" + (attachment != null) +
                '}';
    }

    // --- STATIC INNER CLASS: BUILDER ---
    public static class Builder {
        // Ті самі поля, що і в основному класі
        private String recipient;
        private String subject;
        private String sender;
        private String body = ""; // Значення за замовчуванням
        private File attachment;

        // Конструктор Builder-а приймає обов'язкові поля
        public Builder(String sender, String recipient) {
            this.sender = sender;
            this.recipient = recipient;
        }

        // Методи для встановлення опціональних параметрів
        // Вони повертають 'this', щоб можна було писати ланцюжком (Fluent Interface)

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

        // Метод побудови фінального об'єкта
        public EmailMessage build() {
            if (subject == null) {
                this.subject = "(Без теми)"; // Логіка валідації або дефолтних значень
            }
            return new EmailMessage(this);
        }
    }
}