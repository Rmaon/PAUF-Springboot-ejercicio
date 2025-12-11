package com.example.demo.dto;


public class ProgramadorDTO {

    private Long id;
    private String nombre;
    private String email;
    private Long rolId;
    private String rolNombre; // DEV, TEST, LEAD
    private Integer capacidad;

    public ProgramadorDTO() {}

    public ProgramadorDTO(Long id, String nombre, String email,
                          Long rolId, String rolNombre, Integer capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rolId = rolId;
        this.rolNombre = rolNombre;
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

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}
