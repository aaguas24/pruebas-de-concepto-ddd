package com.example.prueba.infrastructure.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba.domain.entity.Factura;


@Repository
public interface FacturaJpaRepository extends JpaRepository<Factura, UUID> {
	List<Factura> findByUsuario(UUID usuarioId);
}
