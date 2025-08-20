package com.example.prueba.application.service.factura;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Service;

import com.example.prueba.application.dto.DetalleFacturaDTO;
import com.example.prueba.application.dto.FacturaDTO;
import com.example.prueba.application.dto.ProductoDTO;
import com.example.prueba.application.dto.UsuarioDTO;
import com.example.prueba.application.mapper.FacturaMapper;
import com.example.prueba.application.mapper.ProductoMapper;
import com.example.prueba.application.mapper.UsuarioMapper;
import com.example.prueba.application.service.PdfGeneratorApplicationService;
import com.example.prueba.application.service.validador.FacturaValidador;
import com.example.prueba.domain.entity.DetalleFactura;
import com.example.prueba.domain.entity.Factura;
import com.example.prueba.domain.repository.FacturaRepository;
import com.example.prueba.domain.repository.ProductoRepository;
import com.example.prueba.domain.repository.UsuarioRepository;
import com.example.prueba.shared.exceptions.ValidacionException;

@Service
public class FacturaApplicationServiceDefault implements FacturaApplicationService {

  private final FacturaRepository facturaRepository;
  private final UsuarioRepository usuarioRepository;
  private final FacturaMapper facturaMapper;
  private final ProductoRepository ProductoRepository;
  private final ProductoMapper productoMapper;
  private final UsuarioMapper usuarioMapper;
  private final PdfGeneratorApplicationService pdfGeneratorService;

  public FacturaApplicationServiceDefault(FacturaRepository facturaRepository, UsuarioRepository usuarioRepository,
      FacturaMapper facturaMapper, ProductoRepository ProductoRepository, ProductoMapper productoMapper,
      UsuarioMapper usuarioMapper, PdfGeneratorApplicationService pdfGeneratorService) {
    this.facturaRepository = facturaRepository;
    this.usuarioRepository = usuarioRepository;
    this.facturaMapper = facturaMapper;
    this.ProductoRepository = ProductoRepository;
    this.productoMapper = productoMapper;
    this.usuarioMapper = usuarioMapper;
    this.pdfGeneratorService = pdfGeneratorService;
  }

  public FacturaDTO save(FacturaDTO factura) throws Exception {
    try {
      Optional<UsuarioDTO> usuario = Optional
          .ofNullable(usuarioMapper.toUsuarioDTO(usuarioRepository.findById(factura.getUsuarioId()).get()));

      for (DetalleFacturaDTO detalle : factura.getDetalleFacturas()) {
        Optional<ProductoDTO> producto = Optional
            .ofNullable(productoMapper.toProductoDTO(ProductoRepository.findById(detalle.getIdProducto()).get()));
        FacturaValidador.validarExistenciaProducto(producto, detalle);
        detalle.setProducto(producto.get());
      }
      Factura facturaEntity = facturaMapper.toFactura(factura);
      FacturaValidador.validarExistenciaUsuario(usuario, factura);

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
      Optional<UsuarioDTO> usuario = Optional
          .ofNullable(usuarioMapper
              .toUsuarioDTO(usuarioRepository.findById(factura.getUsuarioId()).get()));
      FacturaValidador.validarExistenciaUsuario(usuario, factura);

      Optional<FacturaDTO> facturaResponse = Optional
          .ofNullable(facturaMapper.toFacturaDTO(facturaRepository.findById(factura.getId())));
      FacturaValidador.validarExistenciaFactura(facturaResponse, factura);
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
