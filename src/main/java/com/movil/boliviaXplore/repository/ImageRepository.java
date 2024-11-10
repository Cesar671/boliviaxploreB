package com.movil.boliviaXplore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movil.boliviaXplore.models.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{}
