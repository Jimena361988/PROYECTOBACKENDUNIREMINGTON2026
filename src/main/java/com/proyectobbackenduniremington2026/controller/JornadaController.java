package com.proyectobbackenduniremington2026.controller;

import com.proyectobbackenduniremington2026.model.Jornada;
import com.proyectobbackenduniremington2026.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jornada")
@CrossOrigin(origins = "http://localhost:4200")
public class JornadaController {

    @Autowired
    private JornadaRepository repo;

    @PostMapping
    public ResponseEntity<Jornada> crearSolicitud(@RequestBody Jornada jornada) {
        try {
            Jornada guardada = repo.save(jornada);
            return ResponseEntity.ok(guardada);
        } catch (Exception e) {
            System.err.println("Error al guardar jornada: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}