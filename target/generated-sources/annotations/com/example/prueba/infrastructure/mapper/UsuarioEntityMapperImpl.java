package com.example.prueba.infrastructure.mapper;

import com.example.prueba.domain.entity.Usuario;
import com.example.prueba.infrastructure.repository.entity.UsuarioEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-06T15:46:05-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class UsuarioEntityMapperImpl implements UsuarioEntityMapper {

    @Override
    public UsuarioEntity toEntity(Usuario domain) {
        if ( domain == null ) {
            return null;
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setApellidos( domain.getApellidos() );
        usuarioEntity.setCorreo( domain.getCorreo() );
        usuarioEntity.setDireccion( domain.getDireccion() );
        usuarioEntity.setFechaActualizacion( domain.getFechaActualizacion() );
        usuarioEntity.setFechaRegistro( domain.getFechaRegistro() );
        usuarioEntity.setId( domain.getId() );
        usuarioEntity.setIdentificacion( domain.getIdentificacion() );
        usuarioEntity.setNombres( domain.getNombres() );
        usuarioEntity.setTelefono( domain.getTelefono() );
        usuarioEntity.setTipoIdentificacion( domain.getTipoIdentificacion() );

        return usuarioEntity;
    }

    @Override
    public Usuario toDomain(UsuarioEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setApellidos( entity.getApellidos() );
        usuario.setCorreo( entity.getCorreo() );
        usuario.setDireccion( entity.getDireccion() );
        usuario.setFechaActualizacion( entity.getFechaActualizacion() );
        usuario.setFechaRegistro( entity.getFechaRegistro() );
        usuario.setId( entity.getId() );
        usuario.setIdentificacion( entity.getIdentificacion() );
        usuario.setNombres( entity.getNombres() );
        usuario.setTelefono( entity.getTelefono() );
        usuario.setTipoIdentificacion( entity.getTipoIdentificacion() );

        return usuario;
    }
}
