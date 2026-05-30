package com.proyectobbackenduniremington2026.service;

import com.proyectobbackenduniremington2026.model.Docente;
import com.proyectobbackenduniremington2026.model.Usuario;
import com.proyectobbackenduniremington2026.repository.DocenteRepository;
import com.proyectobbackenduniremington2026.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteService {

    @Autowired private DocenteRepository docenteRepository;
    @Autowired private UsuarioRepository usuarioRepository;

    public Docente guardar(Docente docente) {
        Docente guardado = docenteRepository.save(docente);
        
        // Sincronizar en tabla usuarios
        if (!usuarioRepository.existsByEmail(docente.getCorreoInstitucional())) {
            Usuario u = new Usuario();
            u.setNombre(docente.getNombre() + " " + docente.getApellido());
            u.setEmail(docente.getCorreoInstitucional());
            u.setPassword(docente.getContrasenaAcceso());
            u.setRol("DOCENTE");
            u.setActivo(true);
            usuarioRepository.save(u);
        }
        return guardado;
    }
}