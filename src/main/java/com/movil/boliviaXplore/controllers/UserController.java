package com.movil.boliviaXplore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;
import com.movil.boliviaXplore.models.User;
import com.movil.boliviaXplore.services.UserServiceImplement;


@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServiceImplement userServiceImplement;

    @PostMapping("/create")
    public ResponseEntity<User> login(@RequestBody Map<String, Object> entity) {
        String name =  entity.get("name").toString();
        String email = entity.get("email").toString();
        String urlFoto = entity.get("urlFoto").toString();
        String googleId = entity.get("googleID").toString();
        String authProvider = entity.get("authProvider").toString();

        User user = this.userServiceImplement.createUser(name, email, urlFoto, googleId, authProvider);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
