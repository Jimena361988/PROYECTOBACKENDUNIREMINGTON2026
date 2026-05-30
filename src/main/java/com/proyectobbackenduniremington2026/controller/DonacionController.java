package com.proyectobbackenduniremington2026.controller;

import com.proyectobbackenduniremington2026.model.Donacion;
import com.proyectobbackenduniremington2026.repository.DonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/donaciones")
@CrossOrigin(origins = "http://localhost:4200")
public class DonacionController {

    @Autowired
    private DonacionRepository repository;

    // 1. LISTAR TODAS LAS DONACIONES (Para el panel de Admin)
    @GetMapping
    public List<Donacion> listar() {
        return repository.findAll();
    }

    // 2. REGISTRAR UNA NUEVA DONACIÓN (Desde el formulario del Front)
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Donacion donacion) {
        try {
            Donacion guardada = repository.save(donacion);
            return ResponseEntity.ok(guardada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", "Error al procesar la donación: " + e.getMessage()));
        }
    }
}