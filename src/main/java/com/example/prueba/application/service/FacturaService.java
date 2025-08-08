package com.example.prueba.application.service;

import com.example.prueba.application.dto.FacturaDTO;

public interface FacturaService {
  FacturaDTO save(FacturaDTO factura)throws Exception;
  byte[] generarFacturaPdf(FacturaDTO factura)throws Exception;
}
