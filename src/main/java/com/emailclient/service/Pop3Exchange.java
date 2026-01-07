package com.emailclient.service;

public class Pop3Exchange extends MailExchange {
    @Override
    protected void connect() {
        System.out.println("POP3: Connecting to port 995...");
    }

    @Override
    protected void authenticate() {
        System.out.println("POP3: Sending USER/PASS commands...");
    }

    @Override
    protected void fetchHeaders() {
        System.out.println("POP3: Downloading message list...");
    }
}