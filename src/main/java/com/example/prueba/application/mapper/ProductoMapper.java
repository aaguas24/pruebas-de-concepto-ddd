package com.example.prueba.application.mapper;

import com.example.prueba.application.dto.ProductoDTO;
import com.example.prueba.domain.entity.Producto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductoMapper {
    Producto toEntity(ProductoDTO productoDTO);

    ProductoDTO toDto(Producto producto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Producto partialUpdate(ProductoDTO productoDTO, @MappingTarget Producto producto);
}