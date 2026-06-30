package com.Nanas.demo.dominio.modelos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ubicacion {
    private Integer IdUbicacion;
    private Integer IdUsuario;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private LocalDateTime fechaRegistro;

    public Ubicacion() {
    }

    public Integer getIdUbicacion() {
        return IdUbicacion;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        IdUbicacion = idUbicacion;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    

}
