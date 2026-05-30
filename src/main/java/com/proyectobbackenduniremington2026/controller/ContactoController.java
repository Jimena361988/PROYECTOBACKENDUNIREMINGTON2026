package com.proyectobbackenduniremington2026.controller;

import com.proyectobbackenduniremington2026.model.Contacto;
import com.proyectobbackenduniremington2026.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacto")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactoController {

    @Autowired 
    private ContactoRepository repo;

    @PostMapping
    public ResponseEntity<?> crearContacto(@RequestBody Contacto contacto) {
        try {
            // Validamos que el objeto no llegue nulo
            if (contacto == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El contacto está vacío");
            }
            
            // Guardamos en la base de datos
            Contacto guardado = repo.save(contacto);
            
            // Retornamos el objeto guardado con estado 201 (Creado)
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
            
        } catch (Exception e) {
            // ESTO ES LO QUE TE AYUDARÁ A VER EL ERROR EN LA CONSOLA
            System.err.println("Error al guardar contacto: " + e.getMessage());
            e.printStackTrace();
            
            // Retornamos error 500 al frontend
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error en el servidor: " + e.getMessage());
        }
    }
}