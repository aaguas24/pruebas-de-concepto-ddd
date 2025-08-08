package com.example.prueba.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleFacturaDTO {

	private UUID id;
	
	private UUID idProducto;
	
	private ProductoDTO producto;
	
	private Integer cantidad;
	
	private BigDecimal precioUnitario;
	
	private BigDecimal subTotal;
}
