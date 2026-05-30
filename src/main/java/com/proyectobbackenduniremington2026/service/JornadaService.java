package com.proyectobbackenduniremington2026.service;

import com.proyectobbackenduniremington2026.model.Jornada;
import com.proyectobbackenduniremington2026.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JornadaService {
    @Autowired private JornadaRepository repo;

    public Jornada registrarJornada(Jornada jornada) {
        return repo.save(jornada);
    }
}