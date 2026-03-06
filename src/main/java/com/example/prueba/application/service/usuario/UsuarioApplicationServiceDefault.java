package com.example.prueba.application.service.usuario;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import com.example.prueba.application.dto.FacturaDTO;
import com.example.prueba.application.dto.UsuarioDTO;
import com.example.prueba.application.mapper.FacturaMapper;
import com.example.prueba.application.mapper.UsuarioMapper;
import com.example.prueba.application.service.validador.UsuarioValidador;
import com.example.prueba.domain.entity.Factura;
import com.example.prueba.domain.entity.Usuario;
import com.example.prueba.domain.repository.UsuarioRepository;
import com.example.prueba.shared.exceptions.SinRegistrosException;
import com.example.prueba.shared.exceptions.ValidacionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioApplicationServiceDefault implements UsuarioApplicationService {

    private final UsuarioMapper usuarioMapper;

    private final UsuarioRepository usuarioRepository;

    private final FacturaMapper facturaMapper;

    public UsuarioApplicationServiceDefault(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository,
            FacturaMapper facturaMapper) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
        this.facturaMapper = facturaMapper;
    }

    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Optional<Usuario> getUsuario = usuarioRepository.findByIdentificacion(
                usuarioDTO.getTipoIdentificacion().getCodigo(), usuarioDTO.getIdentificacion());
        UsuarioValidador.validarUsuario(getUsuario);

        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.prePersist();

        return usuarioMapper.toDto(usuarioRepository.save(usuario)
                .orElseThrow(() -> new ValidacionException("Error al guardar usuario.")));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuariosEntity = usuarioRepository.findAll();
        UsuarioValidador.validarUsuarios(usuariosEntity);
        return usuarioMapper.toDto(usuariosEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO findByIdentificacion(String tipoIdentificacion, String identificacion) {
        Optional<Usuario> getUsuario = usuarioRepository.findByIdentificacion(
                tipoIdentificacion, identificacion);
        UsuarioValidador.validarUsuario(getUsuario);
        return usuarioMapper.toDto(getUsuario.orElseThrow(() -> new ValidacionException("Usuario no encontrado.")));
    }

    @Override
    public UsuarioDTO update(UsuarioDTO usuarioDTO) {
        Optional<Usuario> getUsuario = usuarioRepository.findByIdentificacion(
                usuarioDTO.getTipoIdentificacion().getCodigo(), usuarioDTO.getIdentificacion());
        UsuarioValidador.validarUsuario(getUsuario);

        Usuario usuario = getUsuario.get();
        usuario.actualizar(
                usuarioDTO.getDireccion(),
                usuarioDTO.getTelefono(),
                usuarioDTO.getCorreo());

        if (Objects.nonNull(usuarioDTO.getFacturas()) && !usuarioDTO.getFacturas().isEmpty()) {
            for (FacturaDTO factura : usuarioDTO.getFacturas()) {
                Factura facturaMap = facturaMapper.toEntity(factura);
                usuario.setFactura(facturaMap);
            }
        }

        return usuarioMapper.toDto(usuarioRepository.save(usuario)
                .orElseThrow(() -> new ValidacionException("Error al actualizar usuario.")));
    }

    @Override
    public void delete(UUID id) {
        Optional<Usuario> getUsuario = usuarioRepository.findById(id);
        UsuarioValidador.validarUsuarioPorID(getUsuario, id);
        usuarioRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO findById(UUID id) {
        Optional<Usuario> usuarioById = usuarioRepository.findById(id);
        return usuarioMapper
                .toDto(usuarioById.orElseThrow(() -> new ValidacionException("Usuario no encontrado con ID: " + id)));
    }
}
