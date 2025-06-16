package com.example.minicore.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vendedor {

    @Id
    private Long id;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendedor(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Vendedor() {
    }
}
