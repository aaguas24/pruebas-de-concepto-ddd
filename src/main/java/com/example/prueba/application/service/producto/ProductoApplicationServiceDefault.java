package com.example.prueba.application.service.producto;

import java.util.Optional;
import java.util.UUID;

import com.example.prueba.application.dto.ProductoDTO;
import com.example.prueba.application.mapper.ProductoMapper;
import com.example.prueba.domain.repository.ProductoRepository;

public class ProductoApplicationServiceDefault implements ProductoApplicationService {
    private final ProductoRepository productoRepository;

    private final ProductoMapper productoMapper;

    public ProductoApplicationServiceDefault(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    public Optional<ProductoDTO> save(ProductoDTO producto) throws Exception {
        try {
            return Optional.ofNullable(
                    productoMapper.toProductoDTO(productoRepository.save(productoMapper.toProducto(producto)).get()));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Optional<ProductoDTO> findById(UUID id) throws Exception {
        try {
            return Optional.ofNullable(productoMapper.toProductoDTO(productoRepository.findById(id).get()));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
