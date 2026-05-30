package com.proyectobbackenduniremington2026.controller;

import com.proyectobbackenduniremington2026.model.Beneficiario;
import com.proyectobbackenduniremington2026.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sync")
@CrossOrigin(origins = "http://localhost:4200")
public class SyncController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    /**
     * Recibe una lista de beneficiarios capturados en modo offline
     * y los persiste en la base de datos de manera masiva.
     */
    @PostMapping("/beneficiarios")
    public ResponseEntity<?> sincronizarBeneficiarios(@RequestBody List<Beneficiario> beneficiarios) {
        try {
            if (beneficiarios == null || beneficiarios.isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("message", "La lista de sincronización está vacía."));
            }

            // Llamamos al servicio para guardar todos los registros
            // El servicio debe tener un método que maneje List<Beneficiario>
            beneficiarioService.guardarTodo(beneficiarios);

            return ResponseEntity.ok(Map.of(
                "mensaje", "Sincronización exitosa",
                "registrosProcesados", beneficiarios.size(),
                "estado", "Completado"
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("message", "Error al sincronizar datos: " + e.getMessage()));
        }
    }

    /**
     * Endpoint de salud para que el Frontend verifique 
     * si el servidor está disponible antes de intentar sincronizar.
     */
    @GetMapping("/ping")
    public ResponseEntity<String> checkConnection() {
        return ResponseEntity.ok("Servidor de Uniremington alcanzable");
    }
}