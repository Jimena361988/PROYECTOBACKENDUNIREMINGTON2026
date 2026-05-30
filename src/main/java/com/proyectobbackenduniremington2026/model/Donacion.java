package com.proyectobbackenduniremington2026.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "donaciones")
@Data // Genera getters, setters y constructores automáticamente
public class Donacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String donante;

    private String correo;

    @Column(nullable = false)
    private Double monto;

    private String metodoPago;

    private String comentario;

    @Column(name = "fecha_donacion", updatable = false)
    private LocalDateTime fechaDonacion;

    @PrePersist
    protected void onCreate() {
        this.fechaDonacion = LocalDateTime.now();
    }
}