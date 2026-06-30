package com.Nanas.demo.infraestructura.adaptadores.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nanas.demo.infraestructura.adaptadores.persistencia.entidades.ReviewEntity;

public interface SpringDataReviewRepository extends JpaRepository <ReviewEntity, Integer> {
    
}
