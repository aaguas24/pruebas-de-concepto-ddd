package com.example.prueba.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.example.prueba.domain.entity.Producto;
import com.example.prueba.infrastructure.repository.entity.ProductoEntity;

@Mapper(componentModel = "spring")
public interface ProductoEntityMapper {
    ProductoEntity toEntity(Producto domain);

    Producto toDomain(ProductoEntity entity);
}
