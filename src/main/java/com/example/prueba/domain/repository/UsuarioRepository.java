package com.example.prueba.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.prueba.domain.entity.Usuario;

public interface UsuarioRepository {
	Optional<Usuario> save(Usuario usuario);

	List<Usuario> findAll();

	Optional<Usuario> findByIdentificacion(String tipoIdentificacion, String identificacion);

	Optional<Usuario> update(Usuario usuario);

	void delete(UUID id);

	Optional<Usuario> findById(UUID id);
}
