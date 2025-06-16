package com.example.minicore.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private double cantidad;

    @ManyToOne
    @JoinColumn(name="vendedorId")
    private Vendedor vendedor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Venta(Long id, LocalDate fecha, double cantidad, Vendedor vendedor) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.vendedor = vendedor;
    }

    public Venta() {
    }
}
