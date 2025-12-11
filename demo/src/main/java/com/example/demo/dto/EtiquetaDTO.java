package com.example.demo.dto;

public class EtiquetaDTO {

    private Long id;
    private String nombre;
    private String color;

    public EtiquetaDTO() {}

    public EtiquetaDTO(Long id, String nombre, String color) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}