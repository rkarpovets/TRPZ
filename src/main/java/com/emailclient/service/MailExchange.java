package com.emailclient.service;

/**
 * Pattern: Template Method
 */
public abstract class MailExchange {

    public final void startSession() {
        connect();
        authenticate();
        fetchHeaders();
        disconnect();
    }

    protected abstract void connect();
    protected abstract void authenticate();
    protected abstract void fetchHeaders();

    protected void disconnect() {
        System.out.println("Disconnecting from server...");
    }
}