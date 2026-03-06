package com.example.prueba.infrastructure.repository.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.prueba.infrastructure.mapper.UsuarioEntityMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.prueba.domain.entity.Usuario;
import com.example.prueba.domain.repository.UsuarioRepository;
import com.example.prueba.infrastructure.repository.UsuarioJpaRepository;
import com.example.prueba.infrastructure.repository.entity.UsuarioEntity;

@AllArgsConstructor
@Service
public class UsuarioJpaRepositoryAdapter implements UsuarioRepository {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioJpaRepositoryAdapter.class);

	private final UsuarioJpaRepository usuarioJpaRepository;
	private final UsuarioEntityMapper usuarioEntityMapper;

	@Override
	public Optional<Usuario> save(Usuario usuario) {
		UsuarioEntity entity = usuarioEntityMapper.toEntity(usuario);
		UsuarioEntity saved = usuarioJpaRepository.save(entity);
		return Optional.ofNullable(usuarioEntityMapper.toDomain(saved));
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioJpaRepository.findAll().stream()
				.map(usuarioEntityMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Usuario> findByIdentificacion(String tipoIdentificacion, String identificacion) {
		return usuarioJpaRepository.findByTipoIdentificacionAndIdentificacion(tipoIdentificacion, identificacion)
				.map(usuarioEntityMapper::toDomain);
	}

	@Override
	public Optional<Usuario> update(Usuario usuario) {
		UsuarioEntity entity = usuarioEntityMapper.toEntity(usuario);
		UsuarioEntity updated = usuarioJpaRepository.save(entity);
		return Optional.ofNullable(usuarioEntityMapper.toDomain(updated));
	}

	@Override
	public void delete(UUID id) {
		usuarioJpaRepository.deleteById(id);
	}

	@Override
	public Optional<Usuario> findById(UUID id) {
		return usuarioJpaRepository.findById(id).map(usuarioEntityMapper::toDomain);
	}

}
