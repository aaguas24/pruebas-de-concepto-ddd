package com.example.prueba.application.service.factura;

import com.example.prueba.application.dto.FacturaDTO;

public interface FacturaApplicationService {
    public FacturaDTO save(FacturaDTO factura) throws Exception;

    public byte[] generarFacturaPdf(FacturaDTO factura) throws Exception;
}
