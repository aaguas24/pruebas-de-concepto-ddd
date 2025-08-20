package com.example.prueba.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.prueba.shared.enums.TipoIdentificacion;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(columnNames = {"tipo_identificacion","identificacion"}))
@Entity
public class Usuario {
	public Usuario() {}
	public Usuario(UUID id, String tipoIdentificacion, String identificacion, String nombres, String apellidos, String direccion, String telefono, String correo, LocalDateTime fechaRegistro, LocalDateTime fechaActualizacion, List<Factura> facturas) {
		this.id = id;
		this.tipoIdentificacion = tipoIdentificacion;
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.fechaRegistro = fechaRegistro;
		this.fechaActualizacion = fechaActualizacion;
		this.facturas = facturas;
	}

	public UUID getId() { return id; }
	public void setId(UUID id) { this.id = id; }
	public String getTipoIdentificacion() { return tipoIdentificacion; }
	public void setTipoIdentificacion(String tipoIdentificacion) { this.tipoIdentificacion = tipoIdentificacion; }
	public String getIdentificacion() { return identificacion; }
	public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }
	public String getNombres() { return nombres; }
	public void setNombres(String nombres) { this.nombres = nombres; }
	public String getApellidos() { return apellidos; }
	public void setApellidos(String apellidos) { this.apellidos = apellidos; }
	public String getDireccion() { return direccion; }
	public void setDireccion(String direccion) { this.direccion = direccion; }
	public String getTelefono() { return telefono; }
	public void setTelefono(String telefono) { this.telefono = telefono; }
	public String getCorreo() { return correo; }
	public void setCorreo(String correo) { this.correo = correo; }
	public LocalDateTime getFechaRegistro() { return fechaRegistro; }
	public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
	public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
	public void setFechaActualizacion(LocalDateTime fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }
	public List<Factura> getFacturas() { return facturas; }
	public void setFacturas(List<Factura> facturas) { this.facturas = facturas; }
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "tipo_identificacion")
	private String tipoIdentificacion;
	
	@Column 
	private String identificacion;
	
	@Column 
	private String nombres;
	
	@Column 
	private String apellidos;
	
	@Column 
	private String direccion;
	
	@Column 
	private String telefono;
	
	@Column
	private String correo;
	
	@Column(name = "fecha_registro")
	private LocalDateTime fechaRegistro;
	
	@Column(name = "fecha_actualizacion")
	private LocalDateTime fechaActualizacion;
	
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
	private List<Factura> facturas = new ArrayList<>();
	
	@PrePersist
	public void setDataPrePersist() {
	    if (id == null) {
	        id = UUID.randomUUID();
	    }
	    fechaActualizacion =null;
	    fechaRegistro= LocalDateTime.now();
	    
	}
	
	@PreUpdate
	public void setDataUpdate() {

		fechaActualizacion = LocalDateTime.now();

	}
	
	public void setFactura(Factura factura) {
		factura.setUsuario(this);
		facturas.add(factura);
	}
	
	public void deleteFactura(Factura factura) {
		factura.setUsuario(null);
		facturas.remove(factura);
	}
	
}
