package com.movil.boliviaXplore.services;

import com.movil.boliviaXplore.models.User;
import com.movil.boliviaXplore.repository.NotificationRepository;
import com.movil.boliviaXplore.repository.UserRepository;
import com.movil.boliviaXplore.models.Event;
import java.util.List;

import org.springframework.stereotype.Service;

import com.movil.boliviaXplore.models.Notification;

@Service
public class NotificationServiceImplement implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationServiceImplement(NotificationRepository notificationRepository, UserRepository userRepository){
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addNotification(String title, String description, User user, Event event){
        Notification notification = new Notification(title, description, event.getCodEvento(), user.getCodUsuario());
        this.notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAllNotifications(){
        List<Notification> notifications = this.notificationRepository.findAll();
        return notifications;
    }

    @Override
    public List<Notification> getNotificationsByUser(long userId){
        User user = this.userRepository.findById(userId).get();
        return this.notificationRepository.findByCodUsuario(user.getCodUsuario());
    }
}
