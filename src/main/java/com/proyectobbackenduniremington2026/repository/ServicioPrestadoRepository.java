package com.proyectobbackenduniremington2026.repository;

import com.proyectobbackenduniremington2026.model.ServicioPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioPrestadoRepository extends JpaRepository<ServicioPrestado, Long> {
}