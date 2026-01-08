package com.emailclient.service.decorator;

import com.emailclient.model.EmailMessage;

public interface MessageRenderer {
    String render(EmailMessage message);
}