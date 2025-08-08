package com.example.prueba.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.prueba.application.dto.UsuarioDTO;
import com.example.prueba.domain.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	
	UsuarioDTO toUsuarioDTO(Usuario cliente);

	Usuario toUsuario(UsuarioDTO cliente);
	
	List<UsuarioDTO> toListUsuarioDTO(List<Usuario> cliente);
}
