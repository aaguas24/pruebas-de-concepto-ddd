package com.example.prueba.application.service.validador;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import com.example.prueba.domain.entity.Usuario;
import com.example.prueba.shared.exceptions.SinRegistrosException;
import com.example.prueba.shared.exceptions.ValidacionException;

public final class UsuarioValidador {

	public static final void validarUsuario(Optional<Usuario> usuario) throws ValidacionException {
		if (usuario.isPresent()) {
			throw new ValidacionException("El usuario ya se encuentra registrado.");
		}
	}

	public static final void validarUsuarios(List<Usuario> clientesEntity) throws ValidacionException {
		if (Objects.isNull(clientesEntity) || clientesEntity.isEmpty()) {
			throw new SinRegistrosException("No hay usuarios registrados.");
		}
	}

	public static final void validarUsuarioPorID(Optional<Usuario> usuario, UUID id) throws ValidacionException {
		if (!usuario.isPresent()) {
			throw new ValidacionException("El usuario con ID " + id + " no está registrado.");
		}
	}
}
