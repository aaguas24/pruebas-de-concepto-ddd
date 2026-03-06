package com.example.prueba.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba.infrastructure.repository.entity.FacturaEntity;

@Repository
public interface FacturaJpaRepository extends JpaRepository<FacturaEntity, UUID> {

}
