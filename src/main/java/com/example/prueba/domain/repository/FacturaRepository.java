package com.example.prueba.domain.repository;

import java.util.UUID;

import com.example.prueba.domain.entity.Factura;

public interface FacturaRepository {
    Factura save(Factura factura) throws Exception;

    Factura findById(UUID factura) throws Exception;
}
