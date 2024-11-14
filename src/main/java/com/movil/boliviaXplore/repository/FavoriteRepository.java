package com.movil.boliviaXplore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.movil.boliviaXplore.models.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    Favorite findByCodEvento_CodEventoAndCodUsuario_CodUsuario(Long codEventoId, Long codUsuarioId);
}
