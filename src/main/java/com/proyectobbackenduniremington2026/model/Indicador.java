package com.proyectobbackenduniremington2026.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "indicadores") // Nombre exacto de la tabla en MySQL
@Data
public class Indicador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre_indicador")
    private String nombreIndicador;
    
    private String etiqueta;
    private Double valor;
    private Double meta;
    
    @Column(name = "unidad_medida")
    private String unidadMedida;
    
    private String tipo;
    private String descripcion;
}