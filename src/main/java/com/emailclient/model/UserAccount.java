package com.emailclient.view;

import com.emailclient.database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void onLoginButtonClick() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showAlert("Помилка", "Заповніть всі поля!");
            return;
        }

        // Збереження в БД (Full Cycle implementation)
        if (saveAccountToDB(email, password)) {
            showAlert("Успіх", "Акаунт збережено в БД! Перехід до головного вікна...");
            // Тут код відкриття Main Window
        } else {
            showAlert("Помилка", "Не вдалося зберегти дані.");
        }
    }

    private boolean saveAccountToDB(String email, String pass) {
        String insertSQL = "INSERT INTO accounts(email, password) VALUES(?, ?)";

        try (Connection conn = DatabaseHandler.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, email);
            pstmt.setString(2, pass);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}