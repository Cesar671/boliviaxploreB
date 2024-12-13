package com.movil.boliviaXplore.services;

import com.movil.boliviaXplore.models.Notification;
import java.util.List;
import com.movil.boliviaXplore.models.User;
import com.movil.boliviaXplore.models.Event;

public interface NotificationService {
    List<Notification> getAllNotifications();
    List<Notification> getNotificationsByUser(long userId);
    void addNotification(String title, String description, User user, Event event);
}
