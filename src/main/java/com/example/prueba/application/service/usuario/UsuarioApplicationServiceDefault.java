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
    public UsuarioDTO save(UsuarioDTO clienteDTO) throws Exception {
        try {
            Optional<Usuario> getUsuario = usuarioRepository.findByIdentificacion(
                    clienteDTO.getTipoIdentificacion().getCodigo(), clienteDTO.getIdentificacion());
            UsuarioValidador.validarUsuario(getUsuario);

            Usuario cliente = usuarioMapper.toUsuario(clienteDTO);

            return usuarioMapper.toUsuarioDTO(usuarioRepository.save(cliente).get());
        } catch (ValidacionException e) {
            throw new ValidacionException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public List<UsuarioDTO> findAll() throws Exception {
        try {
            List<Usuario> clientesEntity = usuarioRepository.findAll();
            UsuarioValidador.validarUsuarios(clientesEntity);
            return usuarioMapper.toListUsuarioDTO(clientesEntity);
        } catch (SinRegistrosException e) {
            throw new SinRegistrosException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public UsuarioDTO findByIdentificacion(String tipoIdentificacion, String identificacion) throws Exception {
        try {
            Optional<Usuario> getUsuario = usuarioRepository.findByIdentificacion(
                    tipoIdentificacion, identificacion);
            UsuarioValidador.validarUsuario(getUsuario);
            return usuarioMapper.toUsuarioDTO(getUsuario.get());
        } catch (ValidacionException e) {
            throw new ValidacionException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public UsuarioDTO update(UsuarioDTO clienteDTO) throws Exception {
        try {
            Optional<Usuario> getUsuario = usuarioRepository.findByIdentificacion(
                    clienteDTO.getTipoIdentificacion().getCodigo(), clienteDTO.getIdentificacion());
            UsuarioValidador.validarUsuario(getUsuario);

            getUsuario.get().setDireccion(clienteDTO.getDireccion());
            getUsuario.get().setTelefono(clienteDTO.getTelefono());
            getUsuario.get().setCorreo(clienteDTO.getCorreo());
            if (Objects.nonNull(clienteDTO.getFacturas()) && !clienteDTO.getFacturas().isEmpty()) {
                for (FacturaDTO factura : clienteDTO.getFacturas()) {

                    Factura facturaMap = facturaMapper.toFactura(factura);
                    getUsuario.get().setFactura(facturaMap);

                }
            }

            return usuarioMapper.toUsuarioDTO(usuarioRepository.save(getUsuario.get()).get());
        } catch (ValidacionException e) {
            throw new ValidacionException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void delete(UUID id) throws Exception {
        try {
            Optional<Usuario> getUsuario = usuarioRepository.findById(id);
            UsuarioValidador.validarUsuarioPorID(getUsuario, id);
            usuarioRepository.delete(id);

        } catch (ValidacionException e) {
            throw new ValidacionException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public UsuarioDTO findById(UUID id) throws Exception {
        try {
            Optional<Usuario> usuarioById = usuarioRepository.findById(id);
            return usuarioMapper.toUsuarioDTO(usuarioById.get());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
