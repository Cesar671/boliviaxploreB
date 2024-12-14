package com.movil.boliviaXplore.repository;

import com.movil.boliviaXplore.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Date;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
    @Query("SELECT e FROM Event e WHERE " +
           "(e.fechaInicioEvento BETWEEN :startDate AND :endDate OR " +
           " e.fechaFinEvento BETWEEN :startDate AND :endDate OR " +
           " (e.fechaInicioEvento <= :startDate AND e.fechaFinEvento >= :endDate))")
    List<Event> findEventsInMonth(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
