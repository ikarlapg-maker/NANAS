package com.Nanas.demo.infraestructura.adaptadores.persistencia.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer IdReserva;

    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;

    @Column(name = "id_nana", nullable = false)
    private Integer idNana;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDateTime fechaFin;

    @Column(name = "monto_total", nullable = false)
    private BigDecimal montoTotal;

    @Column(name = "estado_pago")
    private String estadoPago;

    @Column(name = "estado_reserva")
    private String estadoReserva;

    @Column(name = "fecha_reserva", updatable = false)
    private LocalDateTime fechaReserva;

    @PrePersist
    protected void onCreate() {
        this.fechaReserva = LocalDateTime.now();
        if (this.estadoPago == null) this.estadoPago = "PENDIENTE";
        if (this.estadoReserva == null) this.estadoReserva = "PENDIENTE";
    }

    public Integer getIdReserva() {
        return IdReserva;
    }

    public void setIdReserva(Integer idReserva) {
        IdReserva = idReserva;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdNana() {
        return idNana;
    }

    public void setIdNana(Integer idNana) {
        this.idNana = idNana;
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
