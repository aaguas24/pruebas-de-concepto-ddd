package com.example.prueba.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.prueba.domain.entity.DetalleFactura;

public interface DetalleFacturaRepository {
	DetalleFactura guardar(DetalleFactura detalleFactura);
	Optional<DetalleFactura> buscarPorId(UUID id);
	List<DetalleFactura> buscarPorFactura(UUID facturaId);
}
