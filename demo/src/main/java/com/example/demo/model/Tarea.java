package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, length = 1000)
    private String descripcion;

    @Column(name = "story_point", nullable = false)
    private Integer storyPoint;

    @ManyToOne(optional = false)
    @JoinColumn(name = "prioridad_id", nullable = false)
    private PrioridadTarea prioridad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "estado_id", nullable = false)
    private EstadoTarea estado;

    @Column(name = "estimacion_horas", nullable = false)
    private Integer estimacionHoras;

    @Column(name = "horas_invertidas", nullable = false)
    private Integer horasInvertidas;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "ult_actualizacion", nullable = false)
    private LocalDateTime ultActualizacion;

    public Tarea() {}

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
        this.ultActualizacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.ultActualizacion = LocalDateTime.now();
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStoryPoint() {
        return storyPoint;
    }

    public void setStoryPoint(Integer storyPoint) {
        this.storyPoint = storyPoint;
    }

    public PrioridadTarea getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(PrioridadTarea prioridad) {
        this.prioridad = prioridad;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    public Integer getEstimacionHoras() {
        return estimacionHoras;
    }

    public void setEstimacionHoras(Integer estimacionHoras) {
        this.estimacionHoras = estimacionHoras;
    }

    public Integer getHorasInvertidas() {
        return horasInvertidas;
    }

    public void setHorasInvertidas(Integer horasInvertidas) {
        this.horasInvertidas = horasInvertidas;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getUltActualizacion() {
        return ultActualizacion;
    }

    public void setUltActualizacion(LocalDateTime ultActualizacion) {
        this.ultActualizacion = ultActualizacion;
    }
}
