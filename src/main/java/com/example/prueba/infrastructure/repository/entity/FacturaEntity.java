package com.example.prueba.infrastructure.repository.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class FacturaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@JsonBackReference
	private UsuarioEntity usuario;

	@Column(name = "fecha_emision")
	private LocalDateTime fechaEmision;

	@Column
	private BigDecimal total;

	@Column
	private String estado;

	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<DetalleFacturaEntity> detalleFacturas = new ArrayList<>();

	@Column(name = "sub_total")
	private BigDecimal subTotal;

	@Column
	private BigDecimal impuestos;

	@Column(name = "total_pagado")
	private BigDecimal totalPagado;

	@PrePersist
	private void prePersist() {
		fechaEmision = LocalDateTime.now();
	}

}