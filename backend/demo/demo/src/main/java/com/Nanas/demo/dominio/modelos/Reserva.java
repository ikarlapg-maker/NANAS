package com.Nanas.demo.dominio.modelos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Reserva {
    private Integer IdReserva;
    private Integer IdCliente;
    private Integer IdNana;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private BigDecimal montoTotal;
    private String estadoPago;
    private String estadoReserva;
    private LocalDateTime fechaReserva;

    public Reserva() {
    }

    public Integer getIdReserva() {
        return IdReserva;
    }

    public void setIdReserva(Integer idReserva) {
        IdReserva = idReserva;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer idCliente) {
        IdCliente = idCliente;
    }

    public Integer getIdNana() {
        return IdNana;
    }

    public void setIdNana(Integer idNana) {
        IdNana = idNana;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }


    

    

    
}
