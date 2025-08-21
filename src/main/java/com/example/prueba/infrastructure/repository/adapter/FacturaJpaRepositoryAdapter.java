package com.example.prueba.infrastructure.repository.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.prueba.domain.entity.Factura;
import com.example.prueba.domain.repository.FacturaRepository;
import com.example.prueba.infrastructure.repository.FacturaJpaRepository;

public class FacturaJpaRepositoryAdapter implements FacturaRepository {

	private final FacturaJpaRepository facturaJpaRepository;

	public FacturaJpaRepositoryAdapter(FacturaJpaRepository facturaJpaRepository) {
		this.facturaJpaRepository = facturaJpaRepository;
	}

	@Override
	public Factura guardar(Factura factura) {
		return facturaJpaRepository.save(factura);
	}

	@Override
	public Optional<Factura> buscarPorId(UUID id) {

		return facturaJpaRepository.findById(id);
	}

	@Override
	public List<Factura> buscarPorUsuario(UUID usuarioId) {
		return facturaJpaRepository.findByUsuario(usuarioId);
	}

}
