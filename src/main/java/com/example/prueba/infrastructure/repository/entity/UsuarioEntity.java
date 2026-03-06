package com.example.prueba.infrastructure.repository.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(columnNames = { "tipo_identificacion",
		"identificacion" }))
@Entity
public class UsuarioEntity {

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
	private List<FacturaEntity> facturas = new ArrayList<>();

	@PrePersist
	public void setDataPrePersist() {
		if (id == null) {
			id = UUID.randomUUID();
		}
		fechaActualizacion = null;
		fechaRegistro = LocalDateTime.now();

	}

	@PreUpdate
	public void setDataUpdate() {
		fechaActualizacion = LocalDateTime.now();
	}

}