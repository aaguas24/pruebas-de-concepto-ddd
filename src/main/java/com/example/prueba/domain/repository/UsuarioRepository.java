package com.example.prueba.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba.domain.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

	Optional<Usuario> findByTipoIdentificacionAndIdentificacion(String Tipoidentificacion, String identificacion);
}
