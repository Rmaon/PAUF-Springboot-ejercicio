package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_sprint")
public class EstadoSprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Valores esperados: PLANNED, ACTIVE, CLOSED
    @Column(nullable = false, unique = true, length = 30)
    private String nombre;

    public EstadoSprint() {
    }

    public EstadoSprint(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}