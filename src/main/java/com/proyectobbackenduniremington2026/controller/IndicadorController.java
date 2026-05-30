package com.proyectobbackenduniremington2026.controller;

import com.proyectobbackenduniremington2026.service.IndicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/indicadores")
@CrossOrigin(origins = "http://localhost:4200")
public class IndicadorController {

    @Autowired
    private IndicadorService indicadorService;

    // Devuelve métricas de indicadores calculadas desde servicios y beneficiarios.
    @GetMapping
    public ResponseEntity<Map<String, Object>> listar() {
        return ResponseEntity.ok(indicadorService.getDashboardCompleto());
    }

    // Alias para la misma información del dashboard.
    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> getDashboard() {
        return ResponseEntity.ok(indicadorService.getDashboardCompleto());
    }
}