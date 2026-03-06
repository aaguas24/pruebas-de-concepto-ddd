package com.example.prueba.application.service.factura;

import com.example.prueba.application.dto.FacturaDTO;

public interface FacturaApplicationService {
    public FacturaDTO save(FacturaDTO factura);

    public byte[] generarFacturaPdf(FacturaDTO factura);
}
