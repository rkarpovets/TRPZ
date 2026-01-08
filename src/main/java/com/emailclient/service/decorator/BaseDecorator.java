package com.emailclient.service.decorator;

import com.emailclient.model.EmailMessage;

public abstract class BaseDecorator implements MessageRenderer {
    protected MessageRenderer wrappee; // Об'єкт, який ми декоруємо

    public BaseDecorator(MessageRenderer wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public String render(EmailMessage message) {
        return wrappee.render(message);
    }
}