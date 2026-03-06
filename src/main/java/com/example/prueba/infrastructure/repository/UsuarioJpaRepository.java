package com.example.prueba.infrastructure.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.prueba.infrastructure.repository.entity.UsuarioEntity;

@Repository
public interface UsuarioJpaRepository
		extends JpaRepository<UsuarioEntity, UUID>, JpaSpecificationExecutor<UsuarioEntity> {

	Optional<UsuarioEntity> findByTipoIdentificacionAndIdentificacion(String Tipoidentificacion, String identificacion);
}
