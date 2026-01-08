package com.emailclient.service.receiver;

public class Pop3Receiver extends MailReceiver {

    @Override
    protected String getProtocolName() {
        return "POP3";
    }

    @Override
    protected void connect() {
        System.out.println("POP3: Connecting to port 995...");
    }

    @Override
    protected void authenticate() {
        System.out.println("POP3: Authenticating with USER/PASS command...");
    }

    @Override
    protected void fetchHeaders() {
        System.out.println("POP3: Downloading ALL messages to local storage...");
        System.out.println("POP3: Marking messages for deletion on server.");
    }
}