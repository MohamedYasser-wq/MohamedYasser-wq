package com.example.cashout.Adapters;

import java.util.function.Consumer;

public class NotificationClick {
    private Consumer<Notification> notification;

    public NotificationClick(Consumer<Notification> notification) {    this.notification = notification;     }

    public void onClick(Notification notification) {
        this.notification.accept(notification);
    }
}
