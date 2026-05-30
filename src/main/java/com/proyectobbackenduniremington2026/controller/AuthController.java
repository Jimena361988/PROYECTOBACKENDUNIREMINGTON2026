package com.proyectobbackenduniremington2026.controller;

import com.proyectobbackenduniremington2026.model.Usuario;
import com.proyectobbackenduniremington2026.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (usuario.getPassword().equals(password)) {
                return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", "Bienvenido al Panel de Proyección Social",
                    "token", "token-seguro-123",
                    "role", usuario.getRol(),
                    "nombre", usuario.getNombre() != null ? usuario.getNombre() : ""
                ));
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                             .body(Map.of("message", "Credenciales incorrectas"));
    }
    
}