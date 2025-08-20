package com.example.prueba.domain.entity;

import java.io.Serializable;
import com.example.prueba.domain.valueobject.Dinero;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DetalleFactura implements Serializable{
	public DetalleFactura() {}
	public DetalleFactura(UUID id, Factura factura, Producto producto, Integer cantidad, Dinero precioUnitario, Dinero subTotal) {
		this.id = id;
		this.factura = factura;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.subTotal = subTotal;
	}

	public UUID getId() { return id; }
	public void setId(UUID id) { this.id = id; }
	public Factura getFactura() { return factura; }
	public void setFactura(Factura factura) { this.factura = factura; }
	public Producto getProducto() { return producto; }
	public void setProducto(Producto producto) { this.producto = producto; }
	public Integer getCantidad() { return cantidad; }
	public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
	public Dinero getPrecioUnitario() { return precioUnitario; }
	public void setPrecioUnitario(Dinero precioUnitario) { this.precioUnitario = precioUnitario; }
	public Dinero getSubTotal() { return subTotal; }
	public void setSubTotal(Dinero subTotal) { this.subTotal = subTotal; }

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
	private Dinero precioUnitario;

	@Column(name = "sub_Total")
	private Dinero subTotal;
}
