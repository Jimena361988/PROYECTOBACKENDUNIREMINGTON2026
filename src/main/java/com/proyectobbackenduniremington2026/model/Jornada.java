package com.proyectobbackenduniremington2026.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "jornadas")
public class Jornada {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String entidad;
    private String responsable;
    private String whatsapp;
    private String email;
    private String lugar;
    private Integer poblacion;
    
    @Column(columnDefinition = "TEXT")
    private String servicios; 
    
    @Column(name = "info_adicional", columnDefinition = "TEXT")
    private String infoAdicional;

    private LocalDateTime fecha = LocalDateTime.now();

    public Jornada() {}

    // GETTERS Y SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEntidad() { return entidad; }
    public void setEntidad(String entidad) { this.entidad = entidad; }
    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
    public String getWhatsapp() { return whatsapp; }
    public void setWhatsapp(String whatsapp) { this.whatsapp = whatsapp; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }
    public Integer getPoblacion() { return poblacion; }
    public void setPoblacion(Integer poblacion) { this.poblacion = poblacion; }
    public String getServicios() { return servicios; }
    public void setServicios(String servicios) { this.servicios = servicios; }
    public String getInfoAdicional() { return infoAdicional; }
    public void setInfoAdicional(String infoAdicional) { this.infoAdicional = infoAdicional; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}