package com.emailclient.service.interpreter;

import com.emailclient.model.EmailMessage;

public class AndExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(EmailMessage message) {
        // Повертає true, тільки якщо ОБИДВІ умови виконуються
        return expr1.interpret(message) && expr2.interpret(message);
    }
}