package com.proyectobbackenduniremington2026.service;

import com.proyectobbackenduniremington2026.model.Usuario;
import com.proyectobbackenduniremington2026.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Usuario registrarUsuario(Usuario usuario) {
        if (repository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("El correo ya está registrado.");
        }
        usuario.setActivo(false); // Por seguridad
        return repository.save(usuario);
    }
}