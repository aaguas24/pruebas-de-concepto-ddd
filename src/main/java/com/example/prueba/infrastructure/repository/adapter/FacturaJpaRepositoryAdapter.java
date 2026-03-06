package com.example.prueba.infrastructure.repository.adapter;

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
    public Factura save(Factura factura) throws Exception {
        try {
            FacturaEntity entity = facturaEntityMapper.toEntity(factura);
            FacturaEntity saved = facturaJpaRepository.save(entity);
            return facturaEntityMapper.toDomain(saved);
        } catch (Exception e) {
            logger.error(" Error FacturaJpaRepositoryAdapter - save {}", e.getMessage());
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Factura findById(UUID id) throws Exception {
        try {
            logger.info(" FacturaJpaRepositoryAdapter - findById {}", id);
            var entity = facturaJpaRepository.findById(id);

            return entity
                    .map(facturaEntityMapper::toDomain) // Transforma si hay valor
                    .orElseGet(() -> {
                        logger.warn("No se encontró la factura");
                        return new Factura(); // O una instancia vacía
                    });

        } catch (Exception e) {
            logger.error(" Error FacturaJpaRepositoryAdapter - save {}", e.getMessage());
            throw new Exception(e.getMessage());
        }

    }

}
