package com.proyectobbackenduniremington2026.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity @Table(name = "docentes") @Data
public class Docente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    @Column(unique = true) private String documento;
    @Column(unique = true) private String correoInstitucional;
    private String contrasenaAcceso;
}