package com.castillo.proyecto.service;
import com.castillo.proyecto.model.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> listar();
    Producto buscarPorId(Integer id);
}
