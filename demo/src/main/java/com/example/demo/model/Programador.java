package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "programador")
public class Programador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nombre;

    @Column(nullable = false, unique = true, length = 200)
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rol_id", nullable = false)
    private RolProgramador rol;

    @Column(nullable = false)
    private Integer capacidad;

    public Programador() {
    }

    public Programador(Long id, String nombre, String email,
                       RolProgramador rol, Integer capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
        this.capacidad = capacidad;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RolProgramador getRol() {
        return rol;
    }

    public void setRol(RolProgramador rol) {
        this.rol = rol;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}