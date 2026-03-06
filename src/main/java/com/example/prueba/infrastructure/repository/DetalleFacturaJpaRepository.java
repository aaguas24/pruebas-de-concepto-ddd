package com.example.prueba.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba.infrastructure.repository.entity.DetalleFacturaEntity;

@Repository
public interface DetalleFacturaJpaRepository extends JpaRepository<DetalleFacturaEntity, UUID> {

}
