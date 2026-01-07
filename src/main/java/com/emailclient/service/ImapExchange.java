package com.emailclient.service;

public class ImapExchange extends MailExchange {
    @Override
    protected void connect() {
        System.out.println("IMAP: Connecting to port 993 (SSL)...");
    }

    @Override
    protected void authenticate() {
        System.out.println("IMAP: Authenticating via OAuth...");
    }

    @Override
    protected void fetchHeaders() {
        System.out.println("IMAP: Syncing folders...");
    }
}