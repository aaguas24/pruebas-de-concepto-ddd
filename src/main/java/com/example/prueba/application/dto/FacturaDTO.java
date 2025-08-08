package com.example.prueba.application.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
public class FacturaDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	private UUID id;
	
	private UUID usuarioId;
	
	private List<DetalleFacturaDTO> detalleFacturas;

	private LocalDateTime fechaEmision;

	private BigDecimal total;
	
	private String estado;

	private BigDecimal subTotal;
	
	private BigDecimal impuestos;
	
	private BigDecimal totalPagado;
}
