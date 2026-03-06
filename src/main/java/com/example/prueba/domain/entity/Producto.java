package com.example.prueba.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	private UUID id;
	private String nombre;
	private String descipcion;
	private BigDecimal precioUnitario;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaVencimiento;
	private String idProveedor;
	private String categoria;
	private String unidadMedida;
	private String codigoProducto;
	private BigDecimal impuesto;
	private BigDecimal descuento;
	private Boolean esExento;
	private String marca;
	private String modelo;
	private String lote;
	private String origen;

}
