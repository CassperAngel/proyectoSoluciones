package com.castillo.proyecto.service;

import com.castillo.proyecto.model.Producto;
import com.castillo.proyecto.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicelmpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServicelmpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public Producto buscarPorId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }
}
