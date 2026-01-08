package com.emailclient.service.receiver;

/**
 * Pattern: Template Method
 */
public abstract class MailReceiver {

    // Шаблонний метод - final, щоб алгоритм не можна було змінити
    public final void downloadEmails() {
        System.out.println("--- Start downloading via " + getProtocolName() + " ---");
        connect();
        authenticate();
        fetchHeaders();
        disconnect();
        System.out.println("--- Finished ---\n");
    }

    // Абстрактні методи (кроки), які мають реалізувати підкласи
    protected abstract void connect();
    protected abstract void authenticate();
    protected abstract void fetchHeaders();
    protected abstract String getProtocolName();

    // Загальний метод (hook), однаковий для всіх (можна перевизначити за бажанням)
    protected void disconnect() {
        System.out.println("System: Closing connection securely.");
    }
}