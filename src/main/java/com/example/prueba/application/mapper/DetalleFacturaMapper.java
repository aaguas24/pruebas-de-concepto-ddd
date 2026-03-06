package com.example.prueba.application.mapper;

import com.example.prueba.application.dto.DetalleFacturaDTO;
import com.example.prueba.domain.entity.DetalleFactura;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DetalleFacturaMapper {
    DetalleFactura toEntity(DetalleFacturaDTO detalleFacturaDTO);

    DetalleFacturaDTO toDto(DetalleFactura detalleFactura);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DetalleFactura partialUpdate(DetalleFacturaDTO detalleFacturaDTO, @MappingTarget DetalleFactura detalleFactura);
}