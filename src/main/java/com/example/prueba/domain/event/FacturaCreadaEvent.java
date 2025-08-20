package com.example.prueba.domain.event;

import java.time.LocalDateTime;
import java.util.UUID;

public class FacturaCreadaEvent {
    private final UUID facturaId;
    private final LocalDateTime fechaCreacion;

    public FacturaCreadaEvent(UUID facturaId, LocalDateTime fechaCreacion) {
        this.facturaId = facturaId;
        this.fechaCreacion = fechaCreacion;
    }

    public UUID getFacturaId() {
        return facturaId;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}
