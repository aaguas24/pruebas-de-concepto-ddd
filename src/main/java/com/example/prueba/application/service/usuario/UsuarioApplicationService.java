package com.example.prueba.application.service.usuario;

import java.util.List;
import java.util.UUID;

import com.example.prueba.application.dto.UsuarioDTO;

public interface UsuarioApplicationService {
    UsuarioDTO save(UsuarioDTO usuario);

    List<UsuarioDTO> findAll();

    UsuarioDTO findByIdentificacion(String tipoIdentificacion, String identificacion);

    UsuarioDTO update(UsuarioDTO usuario);

    void delete(UUID id);

    UsuarioDTO findById(UUID id);
}
