package com.example.prueba.infrastructure.repository;

import com.example.prueba.domain.entity.Factura;
import com.example.prueba.domain.repository.FacturaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FacturaRepositoryJpa implements FacturaRepository {
    // Implementación usando JPA/Hibernate
    @Override
    public Factura guardar(Factura factura) {
        // lógica de persistencia
        return null;
    }

    @Override
    public Optional<Factura> buscarPorId(UUID id) {
        // lógica de persistencia
        return Optional.empty();
    }

    @Override
    public List<Factura> buscarPorUsuario(UUID usuarioId) {
        // lógica de persistencia
        return List.of();
    }
}
