package com.example.prueba.application.dto;

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
public class ProductoDTO {
	
	private UUID id;

	private String nombre;

	private String descipcion;

	private BigDecimal precioUnitario;

	private LocalDateTime fechaIngreso;

	private LocalDateTime fechaVencimiento;

	private String idProveedor;

	private String categoria;
	
	private String unidadMedida; // Ej: kg, litros, unidades

	private String codigoProducto; // Código interno o SKU

	private BigDecimal impuesto; // Porcentaje o monto del impuesto

	private BigDecimal descuento; // Descuento aplicado al producto

	private Boolean esExento; // Si el producto está exento de impuesto

	private String marca; // Marca del producto

	private String modelo; // Modelo si aplica (electrónica, maquinaria, etc.)

	private String lote; // Lote de fabricación

	private String origen; // País de origen o de fabricación
}
