package com.example.prueba.infrastructure.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.prueba.application.dto.FacturaDTO;
import com.example.prueba.application.dto.UsuarioDTO;
import com.example.prueba.domain.entity.Factura;
import com.example.prueba.domain.entity.Usuario;
import com.example.prueba.domain.exceptions.SinRegistrosException;
import com.example.prueba.domain.exceptions.ValidacionException;
import com.example.prueba.application.mapper.FacturaMapper;
import com.example.prueba.application.mapper.UsuarioMapper;
import com.example.prueba.domain.repository.UsuarioRepository;
import com.example.prueba.application.service.UsuarioService;
@Service
public class UsuarioServiceImpl implements UsuarioService{
	

	private final UsuarioMapper usuarioMapper;
	
	private final UsuarioRepository usuarioRepository;
	
	private final FacturaMapper facturaMapper;
	
	public UsuarioServiceImpl(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository,
			FacturaMapper facturaMapper) {
		this.usuarioMapper = usuarioMapper;
		this.usuarioRepository = usuarioRepository;
		this.facturaMapper = facturaMapper;
	}

	@Override
	public UsuarioDTO save(UsuarioDTO clienteDTO) throws Exception {
		try {
			Optional<Usuario> getUsuario = usuarioRepository.findByTipoIdentificacionAndIdentificacion(
					clienteDTO.getTipoIdentificacion(), clienteDTO.getIdentificacion());
			if (getUsuario.isPresent()) {
				throw new ValidacionException("El usuario ya se encuentra registrado.");
			}

			Usuario cliente = usuarioMapper.toUsuario(clienteDTO);
			Usuario usuarioSave = usuarioRepository.save(cliente);
			return usuarioMapper.toUsuarioDTO(usuarioSave);
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
			if (Objects.isNull(clientesEntity) || clientesEntity.isEmpty()) {
				throw new SinRegistrosException("No hay usuarios registrados.");
			}
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
			Optional<Usuario> getUsuario = usuarioRepository.findByTipoIdentificacionAndIdentificacion(
					tipoIdentificacion, identificacion);
			if (!getUsuario.isPresent()) {
				throw new ValidacionException("El usuario no se encuentra registrado.");
			}
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
			Optional<Usuario> getUsuario = usuarioRepository.findByTipoIdentificacionAndIdentificacion(
					clienteDTO.getTipoIdentificacion(), clienteDTO.getIdentificacion());
			if (!getUsuario.isPresent()) {
				throw new ValidacionException("El usuario no se encuentra registrado.");
			}

			getUsuario.get().setDireccion(clienteDTO.getDireccion());
			getUsuario.get().setTelefono(clienteDTO.getTelefono());
			getUsuario.get().setCorreo(clienteDTO.getCorreo());
			if (Objects.nonNull(clienteDTO.getFacturas()) && !clienteDTO.getFacturas().isEmpty()) {
				for (FacturaDTO factura : clienteDTO.getFacturas()) {

					Factura facturaMap = facturaMapper.toFactura(factura);
					getUsuario.get().setFactura(facturaMap);

				}
			}
			Usuario usuarioSave = usuarioRepository.save(getUsuario.get());
			return usuarioMapper.toUsuarioDTO(usuarioSave);
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
			if (!getUsuario.isPresent()) {
				throw new ValidacionException("El usuario con ID " + id + " no está registrado.");
			}
			usuarioRepository.deleteById(id);

		} catch (ValidacionException e) {
			throw new ValidacionException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	@Override
	public UsuarioDTO findById(UUID id) throws Exception {
		try {
		Optional<Usuario>	usuarioById =  usuarioRepository.findById(id);
		return usuarioMapper.toUsuarioDTO(usuarioById.get());
		} catch (Exception e) {
		throw new Exception(e.getMessage());
		}
	}
}
