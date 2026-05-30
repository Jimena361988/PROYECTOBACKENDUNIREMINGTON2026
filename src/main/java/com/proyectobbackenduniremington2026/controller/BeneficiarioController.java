package com.proyectobbackenduniremington2026.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyectobbackenduniremington2026.model.Beneficiario;
import com.proyectobbackenduniremington2026.service.BeneficiarioService;

@RestController
@RequestMapping("/api/beneficiarios")
@CrossOrigin(origins = "http://localhost:4200")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService service;

    // 1. LISTAR TODOS
    @GetMapping
    public List<Beneficiario> listar() {
        return service.listar();
    }

    // 2. BUSCAR POR DOCUMENTO
    // Corregido: Permite que el buscador de Angular encuentre registros por documento
    @GetMapping("/documento/{documento}")
    public ResponseEntity<Beneficiario> buscarPorDocumento(@PathVariable String documento) {
        return service.buscarPorDocumento(documento)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. CREAR NUEVO
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Beneficiario beneficiario) {
        try {
            Beneficiario guardado = service.guardar(beneficiario);
            return ResponseEntity.ok(guardado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", "Error al crear: " + e.getMessage()));
        }
    }

    // 4. ACTUALIZAR (Corrigiendo el error visual en tu VS Code)
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Beneficiario beneficiario) {
        try {
            // Asegúrate de que tu BeneficiarioService tenga implementado este método
            Beneficiario actualizado = service.actualizar(id, beneficiario);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", "Error al actualizar: " + e.getMessage()));
        }
    }

    // 5. ELIMINAR (Corrigiendo la referencia indefinida)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            service.eliminar(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", "No se pudo eliminar: " + e.getMessage()));
        }
    }
}