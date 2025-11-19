package com.castillo.proyecto.controller;

import com.castillo.proyecto.model.Producto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PagoController {

    @GetMapping("/pago")
    public String mostrarPago(Model model, HttpSession session) {

        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");
        model.addAttribute("carrito", carrito);

        double total = 0;

        if (carrito != null && !carrito.isEmpty()) {

            total = carrito.stream()
                    .mapToDouble(p -> {
                        try {
                            return Double.parseDouble(p.getPrecio()); // <- AQUÍ SE ARREGLA
                        } catch (Exception e) {
                            return 0;
                        }
                    }).sum();
        }

        model.addAttribute("total", total);

        return "pago";  // pago.html
    }

    @PostMapping("/procesarPago")
    public String procesarPago(HttpSession session, Model model) {

        session.removeAttribute("carrito");

        model.addAttribute("mensaje", "¡Pago realizado con éxito!");

        return "pago_exitoso";
    }
}
