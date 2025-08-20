package com.example.prueba.domain.entity;

import com.example.prueba.domain.valueobject.Dinero;
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


@Entity
public class Factura {
	// Raíz de agregado

	public Factura() {}

	public Factura(UUID id, Usuario usuario, LocalDateTime fechaEmision, String estado, List<DetalleFactura> detalleFacturas, Dinero subTotal, Dinero impuestos, Dinero totalPagado, Dinero total) {
		this.id = id;
		this.usuario = usuario;
		this.fechaEmision = fechaEmision;
		this.estado = estado;
		this.detalleFacturas = detalleFacturas;
		this.subTotal = subTotal;
		this.impuestos = impuestos;
		this.totalPagado = totalPagado;
		this.total = total;
	}

	public UUID getId() { return id; }
	public void setId(UUID id) { this.id = id; }
	public Usuario getUsuario() { return usuario; }
	public void setUsuario(Usuario usuario) { this.usuario = usuario; }
	public LocalDateTime getFechaEmision() { return fechaEmision; }
	public void setFechaEmision(LocalDateTime fechaEmision) { this.fechaEmision = fechaEmision; }
	public String getEstado() { return estado; }
	public void setEstado(String estado) { this.estado = estado; }
	public List<DetalleFactura> getDetalleFacturas() { return detalleFacturas; }
	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) { this.detalleFacturas = detalleFacturas; }
	public Dinero getSubTotal() { return subTotal; }
	public void setSubTotal(Dinero subTotal) { this.subTotal = subTotal; }
	public Dinero getImpuestos() { return impuestos; }
	public void setImpuestos(Dinero impuestos) { this.impuestos = impuestos; }
	public Dinero getTotalPagado() { return totalPagado; }
	public void setTotalPagado(Dinero totalPagado) { this.totalPagado = totalPagado; }
	public Dinero getTotal() { return total; }
	public void setTotal(Dinero total) { this.total = total; }
	// Raíz de agregado
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@JsonBackReference
	private Usuario usuario;

	@Column(name = "fecha_emision")
	private LocalDateTime fechaEmision;

	@Column
	private String estado;

	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<DetalleFactura> detalleFacturas = new ArrayList<>();

	@Column(name = "sub_total")
	private Dinero subTotal;

	@Column
	private Dinero impuestos;

	@Column(name = "total-pagado")
	private Dinero totalPagado;

	@Column
	private Dinero total;

	@PrePersist
	private void prePersist() {
		fechaEmision = LocalDateTime.now();
	}

	// Invariante: una factura debe tener al menos un detalle
	public void validarInvariantes() {
		if (detalleFacturas == null || detalleFacturas.isEmpty()) {
			throw new IllegalStateException("La factura debe tener al menos un detalle");
		}
		if (usuario == null) {
			throw new IllegalStateException("La factura debe tener usuario");
		}
	}

	public void agregarDetalle(DetalleFactura detalleFactura) {
		detalleFactura.setFactura(this);
		detalleFacturas.add(detalleFactura);
	}

	public void calcularTotales() {
		Dinero subTotalCalc = new Dinero(java.math.BigDecimal.ZERO, "COP");
		Dinero impuestosCalc = new Dinero(java.math.BigDecimal.ZERO, "COP");
		for (DetalleFactura detalle : detalleFacturas) {
			if (detalle.getSubTotal() != null) {
				subTotalCalc = subTotalCalc.sumar(detalle.getSubTotal());
			}
			// Suponiendo que el impuesto está en el producto
			if (detalle.getProducto() != null && detalle.getProducto().getImpuesto() != null) {
				impuestosCalc = impuestosCalc.sumar(new Dinero(detalle.getProducto().getImpuesto(), "COP"));
			}
		}
		this.subTotal = subTotalCalc;
		this.impuestos = impuestosCalc;
		this.total = subTotal.sumar(impuestos);
	}
}
