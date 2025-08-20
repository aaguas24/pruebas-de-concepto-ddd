package com.example.prueba.application.service.usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.prueba.domain.entity.Usuario;
import com.example.prueba.domain.repository.UsuarioRepository;

public class UsuarioApplicationServiceDefault {

    private final UsuarioRepository usuarioRepository;

    public UsuarioApplicationServiceDefault(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.guardar(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.buscarTodos();
    }

    public Optional<Usuario> findByIdentificacion(String tipoIdentificacion, String identificacion) {
        return usuarioRepository.buscarPorIdentificacion(tipoIdentificacion, identificacion);
    }

    public Usuario update(Usuario usuario) {
        return usuarioRepository.actualizar(usuario);
    }

    public void delete(UUID id) {
        usuarioRepository.eliminar(id);
    }

    public Optional<Usuario> findById(UUID id) {
        return usuarioRepository.buscarPorId(id);
    }
}
