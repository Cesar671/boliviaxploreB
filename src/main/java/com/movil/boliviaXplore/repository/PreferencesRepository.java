package com.movil.boliviaXplore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movil.boliviaXplore.models.Preferences;

@Repository
public interface PreferencesRepository extends JpaRepository<Preferences, Long>{
}
