package com.proyectobbackenduniremington2026.controller;

import com.proyectobbackenduniremington2026.model.Docente;
import com.proyectobbackenduniremington2026.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/docentes")
@CrossOrigin(origins = "http://localhost:4200")
public class DocenteController {

    @Autowired private DocenteService service;

    @PostMapping
    public Docente guardar(@RequestBody Docente docente) {
        return service.guardar(docente);
    }
}