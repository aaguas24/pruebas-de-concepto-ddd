package com.example.prueba.application.service.usuario;

import java.util.List;
import java.util.UUID;

import com.example.prueba.application.dto.UsuarioDTO;

public interface UsuarioApplicationService {
    UsuarioDTO save(UsuarioDTO cliente) throws Exception;

    List<UsuarioDTO> findAll() throws Exception;

    UsuarioDTO findByIdentificacion(String tipoIdentificacion, String identificacion) throws Exception;

    UsuarioDTO update(UsuarioDTO cliente) throws Exception;

    void delete(UUID id) throws Exception;

    UsuarioDTO findById(UUID id) throws Exception;
}
