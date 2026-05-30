package com.proyectobbackenduniremington2026.service;

import com.proyectobbackenduniremington2026.model.Seguimiento;
import com.proyectobbackenduniremington2026.repository.SeguimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeguimientoService {

    @Autowired
    private SeguimientoRepository repository;

    public Seguimiento guardar(Seguimiento seguimiento) {
        return repository.save(seguimiento);
    }

    public List<Seguimiento> listar() {
        return repository.findAll();
    }

    public List<Seguimiento> listarPorServicio(Long servicioId) {
        return repository.findByServicioId(servicioId);
    }
}