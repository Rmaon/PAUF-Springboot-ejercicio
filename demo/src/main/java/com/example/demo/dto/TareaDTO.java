package com.example.demo.dto;

public class TareaDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private Integer storyPoint;

    private Long prioridadId;
    private String prioridadNombre; // LOW, MEDIUM, HIGH, CRITICAL

    private Long estadoId;
    private String estadoNombre; // TODO, DOING, REVIEW, DONE

    private Integer estimacionHoras;
    private Integer horasInvertidas;

    public TareaDTO() {}

    public TareaDTO(Long id,
                    String titulo,
                    String descripcion,
                    Integer storyPoint,
                    Long prioridadId,
                    String prioridadNombre,
                    Long estadoId,
                    String estadoNombre,
                    Integer estimacionHoras,
                    Integer horasInvertidas) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.storyPoint = storyPoint;
        this.prioridadId = prioridadId;
        this.prioridadNombre = prioridadNombre;
        this.estadoId = estadoId;
        this.estadoNombre = estadoNombre;
        this.estimacionHoras = estimacionHoras;
        this.horasInvertidas = horasInvertidas;
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

    public Long getPrioridadId() {
        return prioridadId;
    }

    public void setPrioridadId(Long prioridadId) {
        this.prioridadId = prioridadId;
    }

    public String getPrioridadNombre() {
        return prioridadNombre;
    }

    public void setPrioridadNombre(String prioridadNombre) {
        this.prioridadNombre = prioridadNombre;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
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
}
