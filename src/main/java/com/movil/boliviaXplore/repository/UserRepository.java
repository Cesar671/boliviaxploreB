package com.movil.boliviaXplore.repository;

import com.movil.boliviaXplore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByCorreoUsuario(String email);
}
