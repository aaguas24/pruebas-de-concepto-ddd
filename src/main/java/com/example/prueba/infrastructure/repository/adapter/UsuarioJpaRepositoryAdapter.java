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
	public Usuario guardar(Usuario usuario) {
		return usuarioJpaRepository.save(usuario);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return usuarioJpaRepository.findAll();
	}

	@Override
	public Optional<Usuario> buscarPorIdentificacion(String tipoIdentificacion, String identificacion) {
		return usuarioJpaRepository.findByTipoIdentificacionAndIdentificacion(tipoIdentificacion, identificacion);
	}

	@Override
	public Usuario actualizar(Usuario usuario) {
		return usuarioJpaRepository.save(usuario);
	}

	@Override
	public void eliminar(UUID id) {
		usuarioJpaRepository.deleteById(id);

	}

	@Override
	public Optional<Usuario> buscarPorId(UUID id) {
		return usuarioJpaRepository.findById(id);
	}

}
