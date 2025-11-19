package com.castillo.proyecto.controller;

import com.castillo.proyecto.model.Producto;
import com.castillo.proyecto.service.ProductoService;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarritoController {

    private final ProductoService productoService;

    public CarritoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // MOSTRAR CARRITO
    @GetMapping("/carrito")
    public String mostrarCarrito(HttpSession session, Model model) {

        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new ArrayList<>();
        }

        model.addAttribute("carrito", carrito);
        model.addAttribute("contador", carrito.size());

        return "carrito"; // carrito.html
    }

    // AGREGAR PRODUCTO AL CARRITO
    @GetMapping("/carrito/agregar/{id}")
    public String agregarAlCarrito(@PathVariable Integer id, HttpSession session) {

        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new ArrayList<>();
        }

        Producto producto = productoService.buscarPorId(id);

        if (producto != null) {
            carrito.add(producto);
        }

        session.setAttribute("carrito", carrito);

        return "redirect:/tienda"; // te lleva al home
    }

    // ELIMINAR PRODUCTO DEL CARRITO
    @GetMapping("/carrito/eliminar/{index}")
    public String eliminarDelCarrito(@PathVariable int index, HttpSession session) {

        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        if (carrito != null && index >= 0 && index < carrito.size()) {
            carrito.remove(index);
        }

        session.setAttribute("carrito", carrito);

        return "redirect:/carrito";
    }
}
