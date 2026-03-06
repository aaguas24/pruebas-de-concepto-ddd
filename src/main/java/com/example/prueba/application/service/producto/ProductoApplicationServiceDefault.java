package com.example.prueba.application.service.producto;

import java.util.Optional;
import java.util.UUID;

import com.example.prueba.application.dto.ProductoDTO;
import com.example.prueba.application.mapper.ProductoMapper;
import com.example.prueba.domain.repository.ProductoRepository;
import com.example.prueba.shared.exceptions.ValidacionException;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class ProductoApplicationServiceDefault implements ProductoApplicationService {
    private final ProductoRepository productoRepository;

    private final ProductoMapper productoMapper;

    @Override
    public Optional<ProductoDTO> save(ProductoDTO producto) throws Exception {
        try {
            return Optional.ofNullable(productoMapper.toDto(productoRepository.save(productoMapper.toEntity(producto)).orElseThrow(() -> new ValidacionException("No se pudo mapear el producto"))));
        } catch (ValidacionException e) {
            throw new ValidacionException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Optional<ProductoDTO> findById(UUID id) throws Exception {
        try {
            return Optional.ofNullable(productoMapper.toDto(productoRepository.findById(id).orElseThrow(() -> new ValidacionException("No se pudo mapear el producto"))));
        } catch (ValidacionException e) {
            throw new ValidacionException(e.getMessage());
        } catch (Exception e) {
        throw new Exception(e.getMessage());
    }
    }

}
