package com.Nanas.demo.infraestructura.adaptadores.web.Controladores;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Nanas.demo.aplicacion.puertos.entradas.ReservaService;
import com.Nanas.demo.dominio.modelos.Reserva;
import com.Nanas.demo.dominio.modelos.Ubicacion;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {


    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // 1. Crear / Solicitar Reserva
    @PostMapping
    public ResponseEntity<?> crearReserva(@RequestBody Reserva reserva) {
        try {
            Reserva nuevaReserva = reservaService.solicitarReserva(reserva);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReserva);
        } catch (IllegalArgumentException | IllegalStateException e) {
            // Captura cruces de horario o reserva menor a 12 horas
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar la solicitud de reserva.");
        }
    }

    // 2. Aceptar Reserva (Por parte de la Nana)
    @PatchMapping("/{id}/aceptar")
    public ResponseEntity<?> aceptarReserva(@PathVariable Integer id) {
        try {
            reservaService.aceptarReserva(id);
            return ResponseEntity.ok(Map.of("mensaje", "Reserva aceptada exitosamente."));
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 3. Rechazar Reserva (Por parte de la Nana)
    @PatchMapping("/{id}/rechazar")
    public ResponseEntity<?> rechazarReserva(@PathVariable Integer id) {
        try {
            reservaService.rechazarReserva(id);
            return ResponseEntity.ok(Map.of("mensaje", "Reserva rechazada exitosamente."));
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 4. Simulación de Pago (Por parte del Cliente)
    @PostMapping("/{id}/pagar")
    public ResponseEntity<?> pagarReserva(@PathVariable Integer id) {
        try {
            reservaService.pagarReserva(id);
            return ResponseEntity.ok(Map.of("mensaje", "Pago procesado de manera conforme."));
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 5. Iniciar Servicio (En camino a domicilio)
    @PatchMapping("/{id}/iniciar")
    public ResponseEntity<?> iniciarServicio(@PathVariable Integer id) {
        try {
            reservaService.iniciarServicio(id);
            return ResponseEntity.ok(Map.of("mensaje", "Servicio iniciado. Nana en camino."));
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 6. Finalizar Servicio (Trabajo terminado)
    @PatchMapping("/{id}/finalizar")
    public ResponseEntity<?> finalizarServicio(@PathVariable Integer id) {
        try {
            reservaService.finalizarServicio(id);
            return ResponseEntity.ok(Map.of("mensaje", "Servicio concluido con éxito."));
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 7. Registrar Calificación y Reseña (Módulo de Reviews)
    @PostMapping("/{id}/calificar")
    public ResponseEntity<?> calificarServicio(
            @PathVariable Integer id,
            @RequestBody Map<String, Object> payload) {
        try {
            // Extraemos los parámetros del cuerpo JSON de la petición
            Integer rating = (Integer) payload.get("rating");
            String comentario = (String) payload.get("comentario");

            reservaService.calificarServicio(id, rating, comentario);
            return ResponseEntity.ok(Map.of("mensaje", "Calificación registrada. Reputación recalculada."));
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar la reseña.");
        }
    }

    // 8. RASTREO GPS: Obtener localización en tiempo real de la nana
    @GetMapping("/nana/{idUsuario}/ubicacion")
    public ResponseEntity<?> obtenerUbicacionActualNana(@PathVariable Integer idUsuario) {
        try {
            Ubicacion ubicacion = reservaService.buscarUltimaUbicacionUsuario(idUsuario);
            if (ubicacion == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No hay registros de geolocalización activos para este usuario.");
            }
            return ResponseEntity.ok(ubicacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al recuperar la localización del satélite.");
        }
    }
}
