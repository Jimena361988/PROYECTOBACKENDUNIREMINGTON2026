package com.proyectobbackenduniremington2026.controller;

import com.proyectobbackenduniremington2026.model.ServicioPrestado;
import com.proyectobbackenduniremington2026.repository.ServicioPrestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/servicios") // <--- ESTA ES LA RUTA OFICIAL
@CrossOrigin(origins = "http://localhost:4200")
public class ServicioPrestadoController {

    @Autowired
    private ServicioPrestadoRepository repository;

    @GetMapping
    public List<ServicioPrestado> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ServicioPrestado guardar(@RequestBody ServicioPrestado servicio) {
        return repository.save(servicio);
    }
}