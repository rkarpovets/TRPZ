package com.emailclient.view;

import com.emailclient.network.EmailService;
import com.emailclient.service.receiver.ImapReceiver;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class MainController {

    @FXML
    private ListView<String> emailListView;

    @FXML
    public void onCheckMailButtonClick() {
        emailListView.getItems().add("Завантаження...");

        EmailService service = new EmailService(new ImapReceiver());

        service.setOnSucceeded(event -> {
            emailListView.getItems().clear();
            emailListView.getItems().add("Лист від: example1@gmail.com | Тема: Lab 9");
            emailListView.getItems().add("Лист від: example2@gmail.com | Тема: Hello");
        });

        service.setOnFailed(event -> {
            emailListView.getItems().clear();
            emailListView.getItems().add("Помилка з'єднання!");
            service.getException().printStackTrace();
        });

        service.start();
    }
}