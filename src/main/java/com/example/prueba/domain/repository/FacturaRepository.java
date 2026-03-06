package com.example.prueba.domain.repository;

import java.util.UUID;

import com.example.prueba.domain.entity.Factura;

public interface FacturaRepository {
    Factura save(Factura factura);

    Factura findById(UUID factura);
}
