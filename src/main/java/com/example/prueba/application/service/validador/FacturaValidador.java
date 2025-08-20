package com.example.prueba.application.service.validador;

import java.util.Optional;

import com.example.prueba.application.dto.DetalleFacturaDTO;
import com.example.prueba.application.dto.FacturaDTO;
import com.example.prueba.application.dto.ProductoDTO;
import com.example.prueba.application.dto.UsuarioDTO;
import com.example.prueba.shared.exceptions.ValidacionException;

public final class FacturaValidador {

	public static final void validarExistenciaProducto(Optional<ProductoDTO> objteto, DetalleFacturaDTO detalle)
			throws ValidacionException {

		if (!objteto.isPresent()) {
			throw new ValidacionException("No hay producto con Id " + detalle.getIdProducto());
		}
	}

	public static final void validarExistenciaUsuario(Optional<UsuarioDTO> objteto, FacturaDTO factura)
			throws ValidacionException {

		if (!objteto.isPresent()) {
			throw new ValidacionException("No hay un usuario con id: " + factura.getUsuarioId());
		}
	}

	public static final void validarExistenciaFactura(Optional<FacturaDTO> objteto, FacturaDTO factura)
			throws ValidacionException {

		if (!objteto.isPresent()) {
			throw new ValidacionException("No hay una factura con id: " + factura.getId());
		}

	}
}
