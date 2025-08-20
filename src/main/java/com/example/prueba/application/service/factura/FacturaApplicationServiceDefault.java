package com.example.prueba.application.service.factura;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Service;

import com.example.prueba.domain.entity.Factura;
import com.example.prueba.domain.entity.Usuario;
import com.example.prueba.domain.entity.DetalleFactura;
import com.example.prueba.domain.entity.Producto;
import com.example.prueba.domain.repository.FacturaRepository;
import com.example.prueba.domain.repository.ProductoRepository;
import com.example.prueba.domain.repository.UsuarioRepository;
import com.example.prueba.domain.service.FacturaService;

@Service
public class FacturaApplicationServiceDefault implements FacturaApplicationService {

  private final FacturaRepository facturaRepository;
  private final UsuarioRepository usuarioRepository;
  private final ProductoRepository productoRepository;
  private final UsuarioRepository usuarioRepository;
  private final FacturaService facturaService;

  public FacturaApplicationServiceDefault(FacturaRepository facturaRepository, UsuarioRepository usuarioRepository,
      ProductoRepository productoRepository, FacturaService facturaService) {
    this.facturaRepository = facturaRepository;
    this.usuarioRepository = usuarioRepository;
    this.productoRepository = productoRepository;
    this.facturaService = facturaService;
  }

  public Factura save(Factura factura) {
    factura.validarInvariantes();
    factura.calcularTotales();
    return facturaRepository.guardar(factura);
  }

  }

