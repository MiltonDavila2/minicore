package com.example.minicore.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Regla {
    @Id
    private Long id;
    private double porcentaje;
    private double monto;

    public Regla() {
    }

    public Regla(Long id, double porcentaje, double monto) {
        this.id = id;
        this.porcentaje = porcentaje;
        this.monto = monto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
