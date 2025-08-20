package com.example.prueba.application.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.example.prueba.shared.enums.TipoIdentificacion;
import com.example.prueba.shared.validator.NotEmptyOrNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private UUID id;

	@NotEmptyOrNull(campo = "tipoIdentificacion")
	private TipoIdentificacion tipoIdentificacion;

	@NotEmptyOrNull(campo = "identificacion")
	private String identificacion;

	@NotEmptyOrNull(campo = "nombres")
	private String nombres;

	@NotEmptyOrNull(campo = "apellidos")
	private String apellidos;

	@NotEmptyOrNull(campo = "direccion")
	private String direccion;

	@NotEmptyOrNull(campo = "telefono")
	private String telefono;

	@NotEmptyOrNull(campo = "correo")
	private String correo;

	private LocalDateTime fechaRegistro = LocalDateTime.now();

	private LocalDateTime fechaActualizacion;

	private List<FacturaDTO> facturas;
}
