package com.example.prueba.interfaces.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.application.dto.UsuarioDTO;
import com.example.prueba.application.service.usuario.UsuarioApplicationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	private final UsuarioApplicationService usuarioService;

	public UsuarioController(UsuarioApplicationService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioDTO usuario) throws Exception {
		return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<UsuarioDTO>> findAll() throws Exception {
		return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/find/{tipoIdentificacion}/{identificacion}")
	public ResponseEntity<UsuarioDTO> findByIdentificacion(@PathVariable String tipoIdentificacion,
			@PathVariable String identificacion) throws Exception {
		return new ResponseEntity<>(usuarioService.findByIdentificacion(tipoIdentificacion, identificacion),
				HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuario) throws Exception {
		return new ResponseEntity<>(usuarioService.update(usuario), HttpStatus.OK);
	}

	/*
	 * @DeleteMapping
	 * public ResponseEntity<Void> delete(@RequestBody UsuarioDTO usuario) throws
	 * Exception {
	 * usuarioService.delete(usuario.getId());
	 * return ResponseEntity.status(HttpStatus.OK).build();
	 * }
	 */
}
