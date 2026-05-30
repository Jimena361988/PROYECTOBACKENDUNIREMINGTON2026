package com.proyectobbackenduniremington2026.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contacto")
public class Contacto {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String asunto;

    @Column(columnDefinition = "TEXT")
    private String mensaje;

    // Estos nombres deben coincidir EXACTAMENTE con los de tu tabla en MySQL
    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "numero_identidad")
    private String numeroIdentidad;

    private String celular;

    private LocalDateTime fecha = LocalDateTime.now();

    // Constructor vacío (obligatorio para Hibernate)
    public Contacto() {}

    // GETTERS Y SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getNumeroIdentidad() { return numeroIdentidad; }
    public void setNumeroIdentidad(String numeroIdentidad) { this.numeroIdentidad = numeroIdentidad; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}