package com.example.prueba.domain.service;

import com.example.prueba.domain.entity.Factura;
import com.example.prueba.domain.valueobject.Dinero;

public class FacturaService {
    public Dinero calcularTotal(Factura factura) {
        Dinero total = new Dinero(java.math.BigDecimal.ZERO, "COP");
        for (var detalle : factura.getDetalleFacturas()) {
            total = total.sumar(detalle.getSubtotal());
        }
        return total;
    }
}
