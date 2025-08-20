package com.example.prueba.infrastructure.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.prueba.domain.entity.Usuario;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<Usuario, UUID>, JpaSpecificationExecutor<Usuario> {

	Optional<Usuario> findByTipoIdentificacionAndIdentificacion(String Tipoidentificacion, String identificacion);
}
