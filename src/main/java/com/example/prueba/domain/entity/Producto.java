package com.example.prueba.domain.entity;

import com.example.prueba.domain.valueobject.Dinero;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
	public Producto() {}
	public Producto(UUID id, String nombre, String descipcion, Dinero precioUnitario, LocalDateTime fechaIngreso, LocalDateTime fechaVencimiento, String idProveedor, String categoria, String unidadMedida, String codigoProducto, Dinero impuesto, Dinero descuento, Boolean esExento, String marca, String modelo, String lote, String origen) {
		this.id = id;
		this.nombre = nombre;
		this.descipcion = descipcion;
		this.precioUnitario = precioUnitario;
		this.fechaIngreso = fechaIngreso;
		this.fechaVencimiento = fechaVencimiento;
		this.idProveedor = idProveedor;
		this.categoria = categoria;
		this.unidadMedida = unidadMedida;
		this.codigoProducto = codigoProducto;
		this.impuesto = impuesto;
		this.descuento = descuento;
		this.esExento = esExento;
		this.marca = marca;
		this.modelo = modelo;
		this.lote = lote;
		this.origen = origen;
	}

	public UUID getId() { return id; }
	public void setId(UUID id) { this.id = id; }
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getDescipcion() { return descipcion; }
	public void setDescipcion(String descipcion) { this.descipcion = descipcion; }
	public Dinero getPrecioUnitario() { return precioUnitario; }
	public void setPrecioUnitario(Dinero precioUnitario) { this.precioUnitario = precioUnitario; }
	public LocalDateTime getFechaIngreso() { return fechaIngreso; }
	public void setFechaIngreso(LocalDateTime fechaIngreso) { this.fechaIngreso = fechaIngreso; }
	public LocalDateTime getFechaVencimiento() { return fechaVencimiento; }
	public void setFechaVencimiento(LocalDateTime fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
	public String getIdProveedor() { return idProveedor; }
	public void setIdProveedor(String idProveedor) { this.idProveedor = idProveedor; }
	public String getCategoria() { return categoria; }
	public void setCategoria(String categoria) { this.categoria = categoria; }
	public String getUnidadMedida() { return unidadMedida; }
	public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }
	public String getCodigoProducto() { return codigoProducto; }
	public void setCodigoProducto(String codigoProducto) { this.codigoProducto = codigoProducto; }
	public Dinero getImpuesto() { return impuesto; }
	public void setImpuesto(Dinero impuesto) { this.impuesto = impuesto; }
	public Dinero getDescuento() { return descuento; }
	public void setDescuento(Dinero descuento) { this.descuento = descuento; }
	public Boolean getEsExento() { return esExento; }
	public void setEsExento(Boolean esExento) { this.esExento = esExento; }
	public String getMarca() { return marca; }
	public void setMarca(String marca) { this.marca = marca; }
	public String getModelo() { return modelo; }
	public void setModelo(String modelo) { this.modelo = modelo; }
	public String getLote() { return lote; }
	public void setLote(String lote) { this.lote = lote; }
	public String getOrigen() { return origen; }
	public void setOrigen(String origen) { this.origen = origen; }
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column
	private String nombre;
	
	@Column
	private String descipcion;
	
	@Column
	private Dinero precioUnitario;

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

	@Column(name = "impuesto")
	private Dinero impuesto;

	@Column(name = "descuento")
	private Dinero descuento;

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
