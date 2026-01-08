package com.emailclient.service.interpreter;

import com.emailclient.model.EmailMessage;

public class FromExpression implements Expression {
    private String data;

    public FromExpression(String data) {
        this.data = data.toLowerCase(); // Робимо пошук нечутливим до регістру
    }

    @Override
    public boolean interpret(EmailMessage message) {
        if (message.getSender() == null) return false;
        return message.getSender().toLowerCase().contains(data);
    }
}