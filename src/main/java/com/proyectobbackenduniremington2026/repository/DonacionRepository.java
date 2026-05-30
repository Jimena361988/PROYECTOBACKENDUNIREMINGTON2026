package com.proyectobbackenduniremington2026.repository;

import com.proyectobbackenduniremington2026.model.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonacionRepository extends JpaRepository<Donacion, Long> {
    // Aquí puedes añadir consultas personalizadas si lo necesitas en el futuro
}