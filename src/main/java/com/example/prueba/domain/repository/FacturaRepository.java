package com.example.prueba.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.prueba.domain.entity.Factura;

public interface FacturaRepository {
    Factura guardar(Factura factura);
    Optional<Factura> buscarPorId(UUID id);
    List<Factura> buscarPorUsuario(UUID usuarioId);
}
