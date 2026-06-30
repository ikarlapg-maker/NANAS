package com.Nanas.demo.aplicacion.puertos.entradas;

import com.Nanas.demo.dominio.modelos.Cliente;
import com.Nanas.demo.dominio.modelos.Nana;
import com.Nanas.demo.dominio.modelos.Usuario;

public interface AuthUseCase {
    Cliente registrarCliente(Cliente cliente);
    Nana registrarNana(Nana nana);
    Usuario login(String correo, String password);
}
