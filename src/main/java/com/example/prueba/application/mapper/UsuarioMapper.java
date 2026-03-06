package com.example.prueba.application.mapper;

import com.example.prueba.application.dto.UsuarioDTO;
import com.example.prueba.domain.entity.Usuario;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {
    Usuario toEntity(UsuarioDTO usuarioDTO);

    @AfterMapping
    default void linkFacturas(@MappingTarget Usuario usuario) {
        usuario.getFacturas().forEach(factura -> factura.setUsuario(usuario));
    }

    UsuarioDTO toDto(Usuario usuario);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Usuario partialUpdate(UsuarioDTO usuarioDTO, @MappingTarget Usuario usuario);

    List<UsuarioDTO> toDto(List<Usuario> usuarios);
}