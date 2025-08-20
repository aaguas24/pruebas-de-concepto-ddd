package com.example.prueba.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba.domain.entity.DetalleFactura;

@Repository
public interface DetalleFacturaJpaRepository extends JpaRepository<DetalleFactura, UUID> {

}
