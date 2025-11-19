package com.castillo.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castillo.proyecto.model.Usuario;
import com.castillo.proyecto.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario validarUsuario(String username, String password) {
        return usuarioRepository.findByUsernameAndPassword(username, password);
    }
}
