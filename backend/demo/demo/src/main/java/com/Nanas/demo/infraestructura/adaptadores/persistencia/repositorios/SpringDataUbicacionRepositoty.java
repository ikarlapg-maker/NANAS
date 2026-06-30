package com.Nanas.demo.infraestructura.adaptadores.persistencia.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nanas.demo.infraestructura.adaptadores.persistencia.entidades.UbicacionEntity;

public interface SpringDataUbicacionRepositoty extends JpaRepository<UbicacionEntity, Integer> {
    // Obtiene el último registro de GPS reportado por el usuario
    Optional<UbicacionEntity> findFirstByIdUsuarioOrderByFechaRegistroDesc(Integer idUsuario);
}
