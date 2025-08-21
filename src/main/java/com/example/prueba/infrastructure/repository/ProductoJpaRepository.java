package com.example.prueba.infrastructure.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba.domain.entity.Producto;

@Repository
public interface ProductoJpaRepository extends JpaRepository<Producto, UUID> {
	List<Producto> findByCategoria(String categoria);
}
