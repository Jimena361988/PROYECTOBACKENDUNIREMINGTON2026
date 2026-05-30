package com.proyectobbackenduniremington2026.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "diagnosticos_territoriales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diagnostico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String municipio;
    private String clasificacion;
    private String descripcionProblematica;
    private String prioridad;
}