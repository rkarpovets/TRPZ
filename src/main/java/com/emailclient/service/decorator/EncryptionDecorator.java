package com.emailclient.service.decorator;

import com.emailclient.model.EmailMessage;
import java.util.Base64;

public class EncryptionDecorator extends BaseDecorator {

    public EncryptionDecorator(MessageRenderer wrappee) {
        super(wrappee);
    }

    @Override
    public String render(EmailMessage message) {
        // 1. Отримуємо текст від попереднього декоратора/компонента
        String originalText = super.render(message);

        // 2. Додаємо свою поведінку (шифруємо в Base64)
        return Base64.getEncoder().encodeToString(originalText.getBytes());
    }
}