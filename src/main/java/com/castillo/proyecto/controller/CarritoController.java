package com.castillo.proyecto.controller;

import com.castillo.proyecto.model.CarritoItem;
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

        List<CarritoItem> carrito = (List<CarritoItem>) session.getAttribute("carrito");

        if (carrito == null) carrito = new ArrayList<>();

        double total = carrito.stream()
                .mapToDouble(CarritoItem::getSubtotal)
                .sum();

        model.addAttribute("carrito", carrito);
        model.addAttribute("contador", carrito.size());
        model.addAttribute("total", total);

        return "carrito";
    }


    // AGREGAR PRODUCTO AL CARRITO
    @GetMapping("/carrito/agregar/{id}")
    public String agregarAlCarrito(@PathVariable Integer id, HttpSession session) {

        List<CarritoItem> carrito = (List<CarritoItem>) session.getAttribute("carrito");

        if (carrito == null) carrito = new ArrayList<>();

        Producto producto = productoService.buscarPorId(id);

        if (producto != null) {

            // Buscar si ya existe
            CarritoItem itemExistente = carrito.stream()
                    .filter(item -> item.getProducto().getId().equals(id))
                    .findFirst()
                    .orElse(null);

            if (itemExistente != null) {
                itemExistente.aumentar();
            } else {
                carrito.add(new CarritoItem(producto));
            }
        }

        session.setAttribute("carrito", carrito);
        return "redirect:/tienda";
    }


    // AUMENTAR CANTIDAD
    @GetMapping("/carrito/mas/{id}")
    public String mas(@PathVariable Integer id, HttpSession session) {

        List<CarritoItem> carrito = (List<CarritoItem>) session.getAttribute("carrito");

        carrito.stream()
                .filter(item -> item.getProducto().getId().equals(id))
                .findFirst()
                .ifPresent(CarritoItem::aumentar);

        return "redirect:/carrito";
    }

    // DISMINUIR CANTIDAD
    @GetMapping("/carrito/menos/{id}")
    public String menos(@PathVariable Integer id, HttpSession session) {

        List<CarritoItem> carrito = (List<CarritoItem>) session.getAttribute("carrito");

        carrito.stream()
                .filter(item -> item.getProducto().getId().equals(id))
                .findFirst()
                .ifPresent(CarritoItem::disminuir);

        return "redirect:/carrito";
    }

    // ELIMINAR PRODUCTO DEL CARRITO
    @GetMapping("/carrito/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, HttpSession session) {

        List<CarritoItem> carrito = (List<CarritoItem>) session.getAttribute("carrito");

        carrito.removeIf(item -> item.getProducto().getId().equals(id));

        session.setAttribute("carrito", carrito);

        return "redirect:/carrito";
    }
}
