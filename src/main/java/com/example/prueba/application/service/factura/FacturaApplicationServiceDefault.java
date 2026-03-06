package com.example.prueba.application.service.factura;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.prueba.application.mapper.FacturaMapper;
import com.example.prueba.application.mapper.ProductoMapper;
import com.example.prueba.application.mapper.UsuarioMapper;
import lombok.Data;
import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.prueba.application.dto.DetalleFacturaDTO;
import com.example.prueba.application.dto.FacturaDTO;
import com.example.prueba.application.dto.ProductoDTO;
import com.example.prueba.application.dto.UsuarioDTO;
import com.example.prueba.application.service.PdfGeneratorApplicationService;
import com.example.prueba.application.service.validador.FacturaValidador;
import com.example.prueba.domain.entity.DetalleFactura;
import com.example.prueba.domain.entity.Factura;
import com.example.prueba.domain.repository.FacturaRepository;
import com.example.prueba.domain.repository.ProductoRepository;
import com.example.prueba.domain.repository.UsuarioRepository;
import com.example.prueba.shared.exceptions.ValidacionException;

@Data
@Service
@Transactional
public class FacturaApplicationServiceDefault implements FacturaApplicationService {

  private final FacturaRepository facturaRepository;
  private final UsuarioRepository usuarioRepository;
  private final FacturaMapper facturaMapper;
  private final ProductoRepository productoRepository;
  private final ProductoMapper productoMapper;
  private final UsuarioMapper usuarioMapper;
  private final PdfGeneratorApplicationService pdfGeneratorService;

  public FacturaDTO save(FacturaDTO factura) {
    Optional<UsuarioDTO> usuario = Optional
        .ofNullable(usuarioMapper.toDto(usuarioRepository.findById(factura.getUsuarioId())
            .orElseThrow(() -> new ValidacionException("usuario no encontrado"))));

    for (DetalleFacturaDTO detalle : factura.getDetalleFacturas()) {
      var productoEntity = productoRepository.findById(detalle.getIdProducto())
          .orElseThrow(() -> new ValidacionException("producto no encontrado"));
      Optional<ProductoDTO> producto = Optional
          .ofNullable(productoMapper.toDto(productoEntity));
      FacturaValidador.validarExistenciaProducto(producto, detalle);
      detalle.setProducto(producto.get());
    }
    Factura facturaEntity = facturaMapper.toEntity(factura);
    FacturaValidador.validarExistenciaUsuario(usuario, factura);

    facturaEntity.setUsuario(usuarioMapper.toEntity(usuario.get()));
    for (DetalleFactura detalle : facturaEntity.getDetalleFacturas()) {
      detalle.setFactura(facturaEntity);
    }
    return facturaMapper.toDto(facturaRepository.save(facturaEntity));
  }

  @Override
  public byte[] generarFacturaPdf(FacturaDTO factura) {
    Optional<UsuarioDTO> usuario = Optional
        .ofNullable(usuarioMapper
            .toDto(usuarioRepository.findById(factura.getUsuarioId()).get()));
    FacturaValidador.validarExistenciaUsuario(usuario, factura);

    Optional<FacturaDTO> facturaResponse = Optional
        .ofNullable(facturaMapper.toDto(facturaRepository.findById(factura.getId())));
    FacturaValidador.validarExistenciaFactura(facturaResponse, factura);
    List<List<DetalleFacturaDTO>> detalleChunks = ListUtils.partition(factura.getDetalleFacturas(), 10);

    Map<String, Object> data = new HashMap<>();
    data.put("factura", facturaResponse.get());
    data.put("usuario", usuario.get());
    data.put("detalleChunks", detalleChunks);

    byte[] pdfBytes = pdfGeneratorService.generatePdf("Factura", data);
    return pdfBytes;
  }

}
