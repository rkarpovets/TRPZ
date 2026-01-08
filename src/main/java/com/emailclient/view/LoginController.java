package com.emailclient.view;

import com.emailclient.config.SettingsManager;
import com.emailclient.database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

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

        // Збереження в БД
        if (saveAccountToDB(email, password)) {

            // Після успішного запису в БД ми зберігаємо поточного користувача в глобальний стан
            SettingsManager.getInstance().setCurrentUserEmail(email);

            // (Опціонально) Вивід в консоль для перевірки, що Singleton спрацював
            System.out.println("Singleton оновлено. Поточна сесія для: " +
                    SettingsManager.getInstance().getCurrentUserEmail());

            showAlert("Успіх", "Акаунт збережено! Перехід до головного вікна...");
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

    private void openMainWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/emailclient/view/main-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) emailField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("E-mail Client - Вхідні");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}