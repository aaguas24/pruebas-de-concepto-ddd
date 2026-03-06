package com.example.prueba.domain.repository;

import java.util.Optional;
import java.util.UUID;

import com.example.prueba.domain.entity.Producto;

public interface ProductoRepository {
    public Optional<Producto> save(Producto producto);

    public Optional<Producto> findById(UUID id);
}
