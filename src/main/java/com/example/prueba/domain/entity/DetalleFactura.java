package com.example.prueba.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class DetalleFactura implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;
	private Factura factura;
	private Producto producto;
	private Integer cantidad;
	private BigDecimal precioUnitario;
	private BigDecimal subTotal;

	public DetalleFactura(UUID id, Factura factura, Producto producto, Integer cantidad, BigDecimal precioUnitario,
			BigDecimal subTotal) {
		this.id = id;
		this.factura = factura;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.subTotal = subTotal;
	}

	public DetalleFactura() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
}
