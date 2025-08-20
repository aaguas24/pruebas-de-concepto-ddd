package com.example.prueba.interfaces.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.domain.entity.Usuario;
import com.example.prueba.application.service.usuario.UsuarioApplicationServiceDefault;


@RestController
@RequestMapping("usuario")
public class UsuarioController {

	private final UsuarioApplicationServiceDefault usuarioService;

	public UsuarioController(UsuarioApplicationServiceDefault usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
		Usuario saved = usuarioService.save(usuario);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Usuario>> findAll() {
		return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/find/{tipoIdentificacion}/{identificacion}")
	public ResponseEntity<Usuario> findByIdentificacion(@PathVariable String tipoIdentificacion,
													   @PathVariable String identificacion) {
		return usuarioService.findByIdentificacion(tipoIdentificacion, identificacion)
				.map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
		Usuario updated = usuarioService.update(usuario);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestBody Usuario usuario) {
		usuarioService.delete(usuario.getId());
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
