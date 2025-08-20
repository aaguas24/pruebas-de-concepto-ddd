package com.example.prueba.domain.valueobject;

import java.math.BigDecimal;
import java.util.Objects;

public class Dinero {
    private final BigDecimal valor;
    private final String moneda;

    public Dinero(BigDecimal valor, String moneda) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El valor debe ser positivo");
        }
        this.valor = valor;
        this.moneda = moneda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getMoneda() {
        return moneda;
    }

    public Dinero sumar(Dinero otro) {
        if (!this.moneda.equals(otro.moneda)) {
            throw new IllegalArgumentException("Las monedas deben ser iguales");
        }
        return new Dinero(this.valor.add(otro.valor), this.moneda);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dinero dinero = (Dinero) o;
        return valor.equals(dinero.valor) && moneda.equals(dinero.moneda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, moneda);
    }
}
