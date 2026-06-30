package com.Nanas.demo.infraestructura.adaptadores.persistencia.adaptadores;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.Nanas.demo.dominio.puertos.salidas.ReviewRepositoryPort;
import com.Nanas.demo.infraestructura.adaptadores.persistencia.entidades.ReviewEntity;
import com.Nanas.demo.infraestructura.adaptadores.persistencia.repositorios.SpringDataNanaRepository;
import com.Nanas.demo.infraestructura.adaptadores.persistencia.repositorios.SpringDataReviewRepository;

@Component
public class ReviewPersitenceAdapter implements ReviewRepositoryPort {

    private final SpringDataReviewRepository reviewRepository;
    private final SpringDataNanaRepository nanaRepository;
    

    public ReviewPersitenceAdapter(SpringDataReviewRepository reviewRepository,
            SpringDataNanaRepository nanaRepository) {
        this.reviewRepository = reviewRepository;
        this.nanaRepository = nanaRepository;
    }

    @Override
    public void guardarReview(Integer idReserva, Integer rating, String comentario) {
        ReviewEntity entity = new ReviewEntity();
        entity.setIdReserva(idReserva);
        entity.setRating(rating);
        entity.setComentario(comentario);
        reviewRepository.save(entity);
    }

    @Override
    public void actualizarRatingNana(Integer idNana, BigDecimal nuevoRating, Integer nuevaCantidad) {
        nanaRepository.findById(idNana).ifPresent(nana -> {
            nana.setRatingPromedio(nuevoRating);
            nana.setCantidadReviews(nuevaCantidad);
            nanaRepository.save(nana);
        });
    }
    
}
