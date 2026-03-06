package com.example.prueba.application.mapper;

import com.example.prueba.application.dto.FacturaDTO;
import com.example.prueba.domain.entity.Factura;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FacturaMapper {
    Factura toEntity(FacturaDTO facturaDTO);

    @AfterMapping
    default void linkDetalleFacturas(@MappingTarget Factura factura) {
        factura.getDetalleFacturas().forEach(detalleFactura -> detalleFactura.setFactura(factura));
    }

    FacturaDTO toDto(Factura factura);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Factura partialUpdate(FacturaDTO facturaDTO, @MappingTarget Factura factura);
}