package com.Nanas.demo.infraestructura.adaptadores.persistencia.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nanas.demo.infraestructura.adaptadores.persistencia.entidades.UsuarioEntity;

public interface SpringDataUsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    
    //se buca un usuario por su correo, si no se encuentra retorna un Optional vacio
    Optional<UsuarioEntity> findByCorreo(String correo);
    //verifica si existe un usuario con el correo o dni especificado
    boolean existsByCorreo(String correo);
    boolean existsByDni(String dni);
    
}
