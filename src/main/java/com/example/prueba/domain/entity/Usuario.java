package com.example.prueba.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

	private UUID id;
	private String tipoIdentificacion;
	private String identificacion;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String correo;
	private LocalDateTime fechaRegistro;
	private LocalDateTime fechaActualizacion;
	private List<Factura> facturas = new ArrayList<>();

	/**
	 * Lógica de negocio: inicializar datos antes de persistencia
	 */
	public void prePersist() {
		if (id == null) {
			id = UUID.randomUUID();
		}
		if (fechaRegistro == null) {
			fechaRegistro = LocalDateTime.now();
		}
		fechaActualizacion = null;
	}

	/**
	 * Lógica de negocio: actualizar datos del usuario
	 */
	public void actualizar(String direccion, String telefono, String correo) {
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.fechaActualizacion = LocalDateTime.now();
	}

	/**
	 * Lógica de negocio: agregar factura
	 */
	public void setFactura(Factura factura) {
		factura.setUsuario(this);
		facturas.add(factura);
	}

	/**
	 * Lógica de negocio: eliminar factura
	 */
	public void deleteFactura(Factura factura) {
		factura.setUsuario(null);
		facturas.remove(factura);
	}

}
