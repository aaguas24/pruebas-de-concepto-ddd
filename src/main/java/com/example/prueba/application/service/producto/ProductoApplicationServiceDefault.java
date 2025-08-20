package com.example.prueba.application.service.producto;

import java.util.Optional;
import java.util.UUID;

import com.example.prueba.domain.entity.Producto;
import com.example.prueba.domain.repository.ProductoRepository;

public class ProductoApplicationServiceDefault {
    private final ProductoRepository productoRepository;

    public ProductoApplicationServiceDefault(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto save(Producto producto) {
        return productoRepository.guardar(producto);
    }

    public Optional<Producto> findById(UUID id) {
        return productoRepository.buscarPorId(id);
    }

}
