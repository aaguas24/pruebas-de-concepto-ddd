package com.example.prueba.infrastructure.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Service;

import com.example.prueba.application.dto.DetalleFacturaDTO;
import com.example.prueba.application.dto.FacturaDTO;
import com.example.prueba.application.dto.UsuarioDTO;
import com.example.prueba.domain.entity.DetalleFactura;
import com.example.prueba.domain.entity.Factura;
import com.example.prueba.domain.entity.Producto;
import com.example.prueba.domain.exceptions.ValidacionException;
import com.example.prueba.application.mapper.FacturaMapper;
import com.example.prueba.application.mapper.ProductoMapper;
import com.example.prueba.application.mapper.UsuarioMapper;
import com.example.prueba.domain.repository.FacturaRepository;
import com.example.prueba.application.service.FacturaService;
import com.example.prueba.infrastructure.service.PdfGeneratorService;
import com.example.prueba.application.service.ProductoService;
import com.example.prueba.application.service.UsuarioService;

@Service
public class FacturaServiceImpl implements FacturaService{
	
	private final FacturaRepository facturaRepository;
	private final UsuarioService usuarioService;
	private final FacturaMapper facturaMapper;
	private final ProductoService productoService;
	private final ProductoMapper productoMapper;
	private final UsuarioMapper usuarioMapper;
	private final PdfGeneratorService pdfGeneratorService;
	
	public FacturaServiceImpl(FacturaRepository facturaRepository, UsuarioService usuarioService,
			FacturaMapper facturaMapper, ProductoService productoService, ProductoMapper productoMapper,
			UsuarioMapper usuarioMapper, PdfGeneratorService pdfGeneratorService) {
		this.facturaRepository = facturaRepository;
		this.usuarioService = usuarioService;
		this.facturaMapper = facturaMapper;
		this.productoService = productoService;
		this.productoMapper = productoMapper;
		this.usuarioMapper = usuarioMapper;
		this.pdfGeneratorService = pdfGeneratorService;
	}

	@Override
	public FacturaDTO save(FacturaDTO factura) throws Exception {
		try {
			Optional<UsuarioDTO> usuario = Optional.ofNullable(usuarioService.findById(factura.getUsuarioId()));

			for (DetalleFacturaDTO detalle : factura.getDetalleFacturas()) {
				Optional<Producto> producto = Optional
						.ofNullable(productoMapper.toProducto(productoService.findById(detalle.getIdProducto())));
				if (!producto.isPresent()) {
					throw new ValidacionException("No hay producto con Id " + detalle.getIdProducto());
				}
				detalle.setProducto(productoMapper.toProductoDTO(producto.get()));
			}
			Factura facturaEntity = facturaMapper.toFactura(factura);

			if (!usuario.isPresent()) {
				throw new ValidacionException("No hay un usuario con id: " + factura.getUsuarioId());
			}

			facturaEntity.setUsuario(usuarioMapper.toUsuario(usuario.get()));
			for (DetalleFactura detalle : facturaEntity.getDetalleFacturas()) {
				detalle.setFactura(facturaEntity);
			}
			return facturaMapper.toFacturaDTO(facturaRepository.save(facturaEntity));
		} catch (ValidacionException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	@Override
	public byte[] generarFacturaPdf(FacturaDTO factura) throws Exception {
		try {
			Optional<UsuarioDTO> usuario = Optional.ofNullable(usuarioService.findById(factura.getUsuarioId()));
			if (!usuario.isPresent()) {
				throw new ValidacionException("No hay un usuario con id: " + factura.getUsuarioId());
			}
			Optional<FacturaDTO> facturaResponse = Optional
					.ofNullable(facturaMapper.toFacturaDTO(facturaRepository.findById(factura.getId()).get()));
			if (!facturaResponse.isPresent()) {
				throw new ValidacionException("No hay una factura con id: " + factura.getId());
			}
			
		    List<List<DetalleFacturaDTO>> detalleChunks = ListUtils.partition(factura.getDetalleFacturas(), 10);
			
			Map<String, Object> data = new HashMap<>();
			data.put("factura", facturaResponse.get());
			data.put("cliente", usuario.get());
			data.put("detalleChunks", detalleChunks);

			byte[] pdfBytes = pdfGeneratorService.generatePdf("Factura", data);
			return pdfBytes;
		} catch (ValidacionException e) {
			throw new ValidacionException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

}
