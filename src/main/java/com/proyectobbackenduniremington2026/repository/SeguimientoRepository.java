package com.proyectobbackenduniremington2026.repository;

import com.proyectobbackenduniremington2026.model.Seguimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeguimientoRepository extends JpaRepository<Seguimiento, Long> {
    List<Seguimiento> findByServicioId(Long servicioId);
}
