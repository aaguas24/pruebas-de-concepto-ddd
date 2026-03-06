package com.example.prueba.infrastructure.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.prueba.domain.entity.Factura;
import com.example.prueba.domain.entity.DetalleFactura;
import com.example.prueba.infrastructure.repository.entity.FacturaEntity;

@Mapper(componentModel = "spring", uses = { UsuarioEntityMapper.class, DetalleFacturaEntityMapper.class })
public interface FacturaEntityMapper {

    FacturaEntity toEntity(Factura domain);

    Factura toDomain(FacturaEntity entity);

    @AfterMapping
    default void linkEntityDetails(@MappingTarget FacturaEntity entity, Factura domain) {
        if (entity != null && entity.getDetalleFacturas() != null) {
            entity.getDetalleFacturas().forEach(d -> d.setFactura(entity));
        }
    }

    @AfterMapping
    default void linkDomainDetails(@MappingTarget Factura domain, FacturaEntity entity) {
        if (domain != null && domain.getDetalleFacturas() != null) {
            domain.getDetalleFacturas().forEach(d -> d.setFactura(domain));
        }
    }
}
