package com.Nanas.demo.aplicacion.puertos.entradas;

import java.util.List;

import com.Nanas.demo.dominio.modelos.Nana;

public interface BusquedaNanaUseCase {
    //buscar de nanas sin conexion 
    List<Nana> obtenerTodasLasNanasPublico(String nombre);

    //lista de nanas con conexion y localizacion
    List<Nana> buscarNanasPorCercania(double clienteLat, double clienteLng, double radioKm);


}
