package com.proyectobbackenduniremington2026.controller;

import com.proyectobbackenduniremington2026.model.Seguimiento;
import com.proyectobbackenduniremington2026.service.SeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/seguimientos")
@CrossOrigin(origins = "http://localhost:4200")
public class SeguimientoController {

    @Autowired
    private SeguimientoService seguimientoService;

    @GetMapping
    public List<Seguimiento> listar() {
        return seguimientoService.listar();
    }

    @GetMapping("/servicio/{servicioId}")
    public List<Seguimiento> listarPorServicio(@PathVariable Long servicioId) {
        return seguimientoService.listarPorServicio(servicioId);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Seguimiento seguimiento) {
        try {
            Seguimiento nuevo = seguimientoService.guardar(seguimiento);
            return ResponseEntity.ok(nuevo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", "Error al guardar el seguimiento: " + e.getMessage()));
        }
    }
}
