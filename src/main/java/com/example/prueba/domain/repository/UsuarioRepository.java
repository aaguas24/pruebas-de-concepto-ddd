package com.example.prueba.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.prueba.domain.entity.Usuario;

public interface UsuarioRepository {
	Optional<Usuario> save(Usuario cliente) throws Exception;

	List<Usuario> findAll() throws Exception;

	Optional<Usuario> findByIdentificacion(String tipoIdentificacion, String identificacion) throws Exception;

	Optional<Usuario> update(Usuario cliente) throws Exception;

	void delete(UUID id) throws Exception;

	Optional<Usuario> findById(UUID id) throws Exception;
}
