package com.emailclient.service.decorator;

import com.emailclient.model.EmailMessage;

public class SimpleMessageRenderer implements MessageRenderer {
    @Override
    public String render(EmailMessage message) {
        return message.getBody();
    }
}