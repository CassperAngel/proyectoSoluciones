package com.castillo.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.castillo.proyecto.model.Producto;
import com.castillo.proyecto.service.ProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }


    @GetMapping("/{id}")
    public String verDetalleProducto(@PathVariable Integer id, Model model){
        Producto producto=productoService.buscarPorId(id);

        if(producto==null){
            return "redirect:/tienda";
        }
        model.addAttribute("producto", producto);
        return "Detalles/detalleProd";
    }

}
