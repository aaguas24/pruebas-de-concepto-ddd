package com.example.prueba.infrastructure.repository.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.prueba.domain.entity.Usuario;
import com.example.prueba.domain.repository.UsuarioRepository;
import com.example.prueba.infrastructure.repository.UsuarioJpaRepository;

@Service
public class UsuarioJpaRepositoryAdapter implements UsuarioRepository {

	private final UsuarioJpaRepository usuarioJpaRepository;

	public UsuarioJpaRepositoryAdapter(UsuarioJpaRepository usuarioJpaRepository) {
		this.usuarioJpaRepository = usuarioJpaRepository;
	}

	@Override
	public Optional<Usuario> save(Usuario cliente) throws Exception {
		try {
			return Optional.ofNullable(usuarioJpaRepository.save(cliente));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	@Override
	public List<Usuario> findAll() throws Exception {
		try {
			return usuarioJpaRepository.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Optional<Usuario> findByIdentificacion(String tipoIdentificacion, String identificacion) throws Exception {
		try {
			return usuarioJpaRepository.findByTipoIdentificacionAndIdentificacion(tipoIdentificacion, identificacion);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Optional<Usuario> update(Usuario cliente) throws Exception {
		try {
			return Optional.ofNullable(usuarioJpaRepository.save(cliente));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void delete(UUID id) throws Exception {
		try {
			usuarioJpaRepository.deleteById(id);
			;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Optional<Usuario> findById(UUID id) throws Exception {
		try {
			return usuarioJpaRepository.findById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
