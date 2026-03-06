package com.example.prueba.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.prueba.domain.entity.Usuario;
import com.example.prueba.infrastructure.repository.entity.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface UsuarioEntityMapper {

    @Mapping(target = "facturas", ignore = true)
    UsuarioEntity toEntity(Usuario domain);

    @Mapping(target = "facturas", ignore = true)
    Usuario toDomain(UsuarioEntity entity);
}
