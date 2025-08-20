package com.example.prueba.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.prueba.domain.entity.Producto;

public interface ProductoRepository {
    Producto guardar(Producto producto);
    Optional<Producto> buscarPorId(UUID id);
    List<Producto> buscarPorCategoria(String categoria);
}
