package com.example.prueba.shared.enums;

import java.util.Arrays;

import com.example.prueba.shared.exceptions.ValidacionException;

public enum TipoIdentificacion {

    CEDULA_CIUDADANIA("01", "CC", "Cédula de Ciudadanía"),
    TARJETA_IDENTIDAD("02", "TI", "Tarjeta de Identidad"),
    CEDULA_EXTRANJERIA("03", "CE", "Cédula de Extranjería"),
    PASAPORTE("04", "PA", "Pasaporte"),
    NIT("05", "NIT", "Número de Identificación Tributaria"),
    RUT("06", "RUT", "Registro Único Tributario"),
    NUMERO_IDENTIFICACION_EXTERNA("07", "NIE", "Número de Identificación Externa");

    private String codigo;
    private String codigoTipo;
    private String descripcion;

    TipoIdentificacion(String codigo, String codigoTipo, String descripcion) {
        this.codigo = codigo;
        this.codigoTipo = codigoTipo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCodigoTipo() {
        return codigoTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static TipoIdentificacion fromCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new ValidacionException("El código no puede ser nulo o vacío");
        }
        return Arrays.stream(TipoIdentificacion.values()).filter(valor -> valor.codigo.equals(codigo)).findFirst()
                .orElseThrow(() -> new ValidacionException("Código de identificación no válido: " + codigo));
    }
}
