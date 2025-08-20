package com.example.prueba.infrastructure.repository.adapter;

import java.util.UUID;

import com.example.prueba.domain.entity.Factura;
import com.example.prueba.domain.repository.FacturaRepository;
import com.example.prueba.infrastructure.repository.FacturaJpaRepository;

public class FacturaJpaRepositoryAdapter implements FacturaRepository {

    private final FacturaJpaRepository facturaJpaRepository;

    public FacturaJpaRepositoryAdapter(FacturaJpaRepository facturaJpaRepository) {
        this.facturaJpaRepository = facturaJpaRepository;
    }

    @Override
    public Factura save(Factura factura) throws Exception {
        return facturaJpaRepository.save(factura);
    }

    @Override
    public Factura findById(UUID factura) throws Exception {

        return facturaJpaRepository.findById(factura).get();
    }

}
