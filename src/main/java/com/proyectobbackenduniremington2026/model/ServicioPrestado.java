package com.proyectobbackenduniremington2026.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "servicios_prestados")
public class ServicioPrestado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String servicio;

    @Column(nullable = false)
    private String facultad;

    @Column(nullable = false)
    private String beneficiario;

    @Column(nullable = false)
    private String documento;

    @Column(nullable = false)
    private String municipio;

    @Column(nullable = false)
    private LocalDate fecha;

    // Getters y Setters necesarios para que Spring Boot los use
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getServicio() { return servicio; }
    public void setServicio(String servicio) { this.servicio = servicio; }
    public String getFacultad() { return facultad; }
    public void setFacultad(String facultad) { this.facultad = facultad; }
    public String getBeneficiario() { return beneficiario; }
    public void setBeneficiario(String beneficiario) { this.beneficiario = beneficiario; }
    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public String getMunicipio() { return municipio; }
    public void setMunicipio(String municipio) { this.municipio = municipio; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}