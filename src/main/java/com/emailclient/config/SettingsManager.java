package com.emailclient.config;

/**
 * Патерн: Singleton.
 * Зберігає глобальні налаштування програми та сесію користувача.
 */
public class SettingsManager {

    // 1. Приватне статичне поле для зберігання єдиного екземпляра
    private static SettingsManager instance;

    // Поля налаштувань
    private String serverAddress;
    private int serverPort;
    private String currentUserEmail;
    private String appTheme;

    // 2. Приватний конструктор (забороняє new SettingsManager())
    private SettingsManager() {
        // Імітація завантаження налаштувань з файлу
        this.serverAddress = "imap.ukr.net";
        this.serverPort = 993;
        this.appTheme = "Light";
        System.out.println("Налаштування завантажено.");
    }

    // 3. Публічний метод доступу
    public static synchronized SettingsManager getInstance() {
        if (instance == null) {
            instance = new SettingsManager();
        }
        return instance;
    }

    // Геттери та сеттери
    public String getServerAddress() { return serverAddress; }
    public int getServerPort() { return serverPort; }

    public String getCurrentUserEmail() { return currentUserEmail; }
    public void setCurrentUserEmail(String email) { this.currentUserEmail = email; }

    public String getAppTheme() { return appTheme; }
    public void setAppTheme(String theme) { this.appTheme = theme; }
}