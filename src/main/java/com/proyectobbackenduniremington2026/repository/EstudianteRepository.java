package com.proyectobbackenduniremington2026.repository;

import com.proyectobbackenduniremington2026.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    // Si aquí tienes una línea que diga "findByCodigoEstudiantil", BORRALA.
    // Ese es el error que hace que el backend se apague.
}