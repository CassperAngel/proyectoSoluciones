package com.castillo.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castillo.proyecto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsernameAndPassword(String username, String password);
}
