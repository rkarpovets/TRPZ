package com.emailclient.config;

/**
 * Pattern: Singleton
 */
public class SettingsManager {
    private static SettingsManager instance;
    private String serverHost;
    private int serverPort;
    private String currentUserEmail;

    private SettingsManager() {
        this.serverHost = "smtp.gmail.com";
        this.serverPort = 465;
    }

    public static synchronized SettingsManager getInstance() {
        if (instance == null) {
            instance = new SettingsManager();
        }
        return instance;
    }

    public String getServerHost() { return serverHost; }
    public int getServerPort() { return serverPort; }

    public void setCurrentUserEmail(String email) { this.currentUserEmail = email; }
    public String getCurrentUserEmail() { return currentUserEmail; }
}