package com.example.prueba.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class DetalleFactura implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name="factura_id")
	@JsonBackReference
	private Factura factura;
	
	@ManyToOne
	@JoinColumn(name="producto_id")
	@JsonBackReference
	private Producto producto;
	
	@Column
	private Integer cantidad;
	
	@Column(name = "precio_unitario")
	private BigDecimal precioUnitario;
	
	@Column(name = "sub_Total")
	private BigDecimal subTotal;
}
