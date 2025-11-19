package com.castillo.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castillo.proyecto.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
