package com.emailclient.service.interpreter;

import com.emailclient.model.EmailMessage;

public interface Expression {
    boolean interpret(EmailMessage message);
}