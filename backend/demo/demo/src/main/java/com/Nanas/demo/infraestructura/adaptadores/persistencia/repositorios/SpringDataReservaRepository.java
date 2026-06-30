package com.Nanas.demo.infraestructura.adaptadores.persistencia.repositorios;


import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Nanas.demo.infraestructura.adaptadores.persistencia.entidades.ReservaEntity;

public interface SpringDataReservaRepository extends JpaRepository<ReservaEntity, Integer> {
    
    // para ver si hay un cruze de horario
    @Query("SELECT COUNT(r) > 0 FROM ReservaEntity r WHERE r.idNana = :idNana " +
           "AND r.estadoReserva != 'CANCELADA' " +
           "AND (:inicio < r.fechaFin AND :fin > r.fechaInicio)")
    boolean existsOverlappingReservation(@Param("idNana") Integer idNana, 
                                         @Param("inicio") LocalDateTime inicio, 
                                         @Param("fin") LocalDateTime fin);
}
