package com.emailclient.network;

import com.emailclient.service.receiver.MailReceiver;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class EmailService extends Service<Void> {

    private final MailReceiver receiver;

    public EmailService(MailReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(1000);
                receiver.downloadEmails();
                return null;
            }
        };
    }
}