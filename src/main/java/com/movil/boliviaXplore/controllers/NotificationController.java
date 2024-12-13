package com.movil.boliviaXplore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.movil.boliviaXplore.models.Notification;
import com.movil.boliviaXplore.services.NotificationServiceImplement;

@Controller
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    NotificationServiceImplement notificationServiceImplement;

    @GetMapping("/user/{user}")
    public ResponseEntity<List<Notification>> getMethodName(@PathVariable("user") long idUser) {
        List<Notification> notifications = notificationServiceImplement.getNotificationsByUser(idUser);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }
    
}
