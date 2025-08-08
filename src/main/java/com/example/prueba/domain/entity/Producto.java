package com.example.prueba.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column
	private String nombre;
	
	@Column
	private String descipcion;
	
	@Column
	private BigDecimal precioUnitario;

	@Column(name = "fecha_Ingreso")
	private LocalDateTime fechaIngreso;
	
	@Column(name = "fecha_vencimiento") 
	private LocalDateTime fechaVencimiento;
	
	@Column
	private String idProveedor;
	
	@Column
	private String categoria;
	
	@Column(name = "unidad_medida", length = 20)
	private String unidadMedida;

	@Column(name = "codigo_producto", unique = true, nullable = false, length = 50)
	private String codigoProducto;

	@Column(name = "impuesto", precision = 10, scale = 2)
	private BigDecimal impuesto;

	@Column(name = "descuento", precision = 10, scale = 2)
	private BigDecimal descuento;

	@Column(name = "es_exento")
	private Boolean esExento;

	@Column(name = "marca", length = 50)
	private String marca;

	@Column(name = "modelo", length = 50)
	private String modelo;

	@Column(name = "lote", length = 30)
	private String lote;

	@Column(name = "origen", length = 50)
	private String origen;

}
