package com.Nanas.demo.dominio.puertos.salidas;

public interface ReviewRepositoryPort {
    
    void guardarReview(Integer idReserva, Integer rating, String comentario);
    void actualizarRatingNana(Integer idNana, java.math.BigDecimal nuevoRating, Integer nuevaCantidad);

}
