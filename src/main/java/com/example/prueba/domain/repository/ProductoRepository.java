package com.example.prueba.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba.domain.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, UUID>{

}
