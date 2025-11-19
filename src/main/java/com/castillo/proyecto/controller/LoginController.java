package com.castillo.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.castillo.proyecto.model.Usuario;
import com.castillo.proyecto.repository.UsuarioRepository;
import com.castillo.proyecto.repository.ProductoRepository;

@Controller
public class LoginController {

    private final UsuarioRepository usuarioRepo;
    private final ProductoRepository productoRepo;

    public LoginController(UsuarioRepository usuarioRepo, ProductoRepository productoRepo) {
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
    }

    @GetMapping("/")
    public String login() {
        return "login"; // login.html
    }

    @PostMapping("/login")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        Usuario usuario = usuarioRepo.findByUsernameAndPassword(username, password);

        if (usuario == null) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }

        // Solo clientes (pero tú dijiste que no existen admins)
        model.addAttribute("usuario", usuario);
        model.addAttribute("productos", productoRepo.findAll());

        return "tienda";
    }

    @GetMapping("/tienda")
    public String Volver(Model model){
        model.addAttribute("productos", productoRepo.findAll());
        return "tienda";
    }
}
