package com.emailclient.service.receiver;

public class ImapReceiver extends MailReceiver {

    @Override
    protected String getProtocolName() {
        return "IMAP";
    }

    @Override
    protected void connect() {
        System.out.println("IMAP: Connecting to port 993 (SSL)...");
    }

    @Override
    protected void authenticate() {
        System.out.println("IMAP: Sending OAuth2 token...");
    }

    @Override
    protected void fetchHeaders() {
        System.out.println("IMAP: Syncing folder structure (Inbox, Sent, Trash)...");
        System.out.println("IMAP: Fetching only message headers (lazy loading).");
    }
}