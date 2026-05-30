package com.proyectobbackenduniremington2026.service;

import com.proyectobbackenduniremington2026.model.Contacto;
import com.proyectobbackenduniremington2026.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    public Contacto guardarContacto(Contacto contacto) {
        // Aquí podrías agregar lógica adicional (ej: enviar correo, validar datos)
        return contactoRepository.save(contacto);
    }
}