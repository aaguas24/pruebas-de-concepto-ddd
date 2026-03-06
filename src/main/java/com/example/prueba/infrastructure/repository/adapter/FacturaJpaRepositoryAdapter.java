package com.example.prueba.infrastructure.repository.adapter;

import java.util.Optional;
import java.util.UUID;

import com.example.prueba.shared.exceptions.ServiceException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactoryFriend;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.prueba.domain.entity.Factura;
import com.example.prueba.domain.repository.FacturaRepository;
import com.example.prueba.infrastructure.repository.FacturaJpaRepository;
import com.example.prueba.infrastructure.repository.entity.FacturaEntity;
import com.example.prueba.infrastructure.mapper.FacturaEntityMapper;

@AllArgsConstructor
@Service
public class FacturaJpaRepositoryAdapter implements FacturaRepository {
    private static final Logger logger = LoggerFactory.getLogger(FacturaJpaRepositoryAdapter.class);
    private final FacturaJpaRepository facturaJpaRepository;
    private final FacturaEntityMapper facturaEntityMapper;

    @Override
    public Factura save(Factura factura) {
        try {
            FacturaEntity entity = facturaEntityMapper.toEntity(factura);
            FacturaEntity saved = facturaJpaRepository.save(entity);
            return facturaEntityMapper.toDomain(saved);
        } catch (Exception e) {
            logger.error("Error en FacturaJpaRepositoryAdapter - save: {}", e.getMessage());
            throw new ServiceException("Error al guardar la factura");
        }
    }

    @Override
    public Factura findById(UUID id) {
        try {
            logger.info("FacturaJpaRepositoryAdapter - findById {}", id);
            Optional<FacturaEntity> entity = facturaJpaRepository.findById(id);
            return entity.map(facturaEntityMapper::toDomain).orElse(null);
        } catch (Exception e) {
            logger.error("Error en FacturaJpaRepositoryAdapter - findById: {}", e.getMessage());
            throw new ServiceException("Error al buscar la factura por ID");
        }
    }

}
