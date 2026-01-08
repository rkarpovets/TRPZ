package com.emailclient.service.decorator;

import com.emailclient.model.EmailMessage;

public class SignatureDecorator extends BaseDecorator {

    public SignatureDecorator(MessageRenderer wrappee) {
        super(wrappee);
    }

    @Override
    public String render(EmailMessage message) {
        String content = super.render(message);

        // Додаємо підпис
        return content + "\n\n-- \nЗ повагою, \nВаш E-mail клієнт (Lab 6)";
    }
}