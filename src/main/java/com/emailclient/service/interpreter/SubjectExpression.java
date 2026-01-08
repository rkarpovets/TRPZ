package com.emailclient.service.interpreter;

import com.emailclient.model.EmailMessage;

public class SubjectExpression implements Expression {
    private String data;

    public SubjectExpression(String data) {
        this.data = data.toLowerCase();
    }

    @Override
    public boolean interpret(EmailMessage message) {
        if (message.getSubject() == null) return false;
        return message.getSubject().toLowerCase().contains(data);
    }
}