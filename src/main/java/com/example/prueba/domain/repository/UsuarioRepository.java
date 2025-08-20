package com.example.prueba.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.prueba.domain.entity.Usuario;

public interface UsuarioRepository {
	Usuario guardar(Usuario usuario);
	List<Usuario> buscarTodos();
	Optional<Usuario> buscarPorIdentificacion(String tipoIdentificacion, String identificacion);
	Usuario actualizar(Usuario usuario);
	void eliminar(UUID id);
	Optional<Usuario> buscarPorId(UUID id);
}
