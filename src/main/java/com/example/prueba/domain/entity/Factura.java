package com.example.prueba.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Factura {

	private UUID id;
	private Usuario usuario;
	private LocalDateTime fechaEmision;
	private BigDecimal total;
	private String estado;
	private List<DetalleFactura> detalleFacturas = new ArrayList<>();
	private BigDecimal subTotal;
	private BigDecimal impuestos;
	private BigDecimal totalPagado;

	/**
	 * Lógica de negocio: inicializar fecha de emisión
	 */
	public void prePersist() {
		if (fechaEmision == null) {
			fechaEmision = LocalDateTime.now();
		}
		if (id == null) {
			id = UUID.randomUUID();
		}
		if (estado == null) {
			estado = "PENDIENTE";
		}
		calcularTotales();
	}

	/**
	 * Lógica de negocio: agregar detalle de factura
	 */
	public void agregarDetalle(DetalleFactura detalleFactura) {
		detalleFactura.setFactura(this);
		detalleFacturas.add(detalleFactura);
		calcularTotales();
	}

	/**
	 * Lógica de negocio: eliminar detalle de factura
	 */
	public void removerDetalle(DetalleFactura detalleFactura) {
		detalleFactura.setFactura(null);
		detalleFacturas.remove(detalleFactura);
		calcularTotales();
	}

	/**
	 * Lógica de negocio: calcular totales de la factura
	 */
	public void calcularTotales() {
		subTotal = detalleFacturas.stream()
				.map(DetalleFactura::getSubTotal)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		if (impuestos == null) {
			impuestos = subTotal.multiply(new BigDecimal("0.19")); // IVA 19%
		}

		total = subTotal.add(impuestos);
	}

	/**
	 * Lógica de negocio: marcar factura como pagada
	 */
	public void marcarPagada(BigDecimal monto) {
		if (monto.compareTo(total) >= 0) {
			this.estado = "PAGADA";
			this.totalPagado = total;
		} else {
			this.estado = "PARCIALMENTE_PAGADA";
			this.totalPagado = monto;
		}
	}

}
