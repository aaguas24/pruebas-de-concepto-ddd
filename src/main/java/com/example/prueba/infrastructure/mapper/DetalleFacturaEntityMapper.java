package com.example.prueba.infrastructure.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.prueba.domain.entity.DetalleFactura;
import com.example.prueba.infrastructure.repository.entity.DetalleFacturaEntity;

@Mapper(componentModel = "spring", uses = { ProductoEntityMapper.class })
public interface DetalleFacturaEntityMapper {

    @Mapping(target = "factura", ignore = true)
    DetalleFacturaEntity toEntity(DetalleFactura domain);

    @Mapping(target = "factura", ignore = true)
    DetalleFactura toDomain(DetalleFacturaEntity entity);
}
