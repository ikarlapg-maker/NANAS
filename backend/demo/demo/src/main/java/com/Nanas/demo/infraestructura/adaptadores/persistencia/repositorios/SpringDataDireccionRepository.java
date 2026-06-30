package com.Nanas.demo.infraestructura.adaptadores.persistencia.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nanas.demo.infraestructura.adaptadores.persistencia.entidades.DireccionEntity;

public interface SpringDataDireccionRepository extends JpaRepository<DireccionEntity, Integer> {

    //busca la primera direccion registrada de un usuario por su id
    Optional<DireccionEntity> findByIdUsuario(Integer idUsuario);
}   
