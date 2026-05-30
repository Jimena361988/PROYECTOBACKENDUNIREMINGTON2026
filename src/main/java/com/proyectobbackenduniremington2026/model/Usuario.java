package com.proyectobbackenduniremington2026.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data // Genera getters, setters y constructores automáticamente
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String password;
    private String rol; // 'admin', 'docente', 'estudiante'
    private boolean activo = false;
}