package com.example.prueba.application.service.producto;

import java.util.Optional;
import java.util.UUID;

import com.example.prueba.application.dto.ProductoDTO;

public interface ProductoApplicationService {
    Optional<ProductoDTO> save(ProductoDTO producto) throws Exception;

    Optional<ProductoDTO> findById(UUID id) throws Exception;
}
