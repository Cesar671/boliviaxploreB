package com.movil.boliviaXplore.repository;

import com.movil.boliviaXplore.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{}
