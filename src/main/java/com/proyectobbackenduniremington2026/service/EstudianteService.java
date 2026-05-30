package com.proyectobbackenduniremington2026.service;

import com.proyectobbackenduniremington2026.model.Estudiante;
import com.proyectobbackenduniremington2026.model.Usuario;
import com.proyectobbackenduniremington2026.repository.EstudianteRepository;
import com.proyectobbackenduniremington2026.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstudianteService {

    @Autowired private EstudianteRepository estudianteRepository;
    @Autowired private UsuarioRepository usuarioRepository;

    public List<Estudiante> obtenerTodos() {
        return estudianteRepository.findAll();
    }

    public Estudiante guardar(Estudiante estudiante) {
        // 1. Guardar en la tabla estudiantes
        Estudiante guardado = estudianteRepository.save(estudiante);

        // 2. Sincronizar en tabla usuarios para permitir el Login
        if (!usuarioRepository.existsByEmail(estudiante.getEmail())) {
            Usuario u = new Usuario();
            u.setNombre(estudiante.getNombre());
            u.setEmail(estudiante.getEmail());
            u.setPassword(estudiante.getPassword()); 
            u.setRol("ESTUDIANTE");
            u.setActivo(true);
            usuarioRepository.save(u);
        }
        return guardado;
    }

    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }
}