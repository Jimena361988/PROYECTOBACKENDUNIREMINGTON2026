package com.proyectobbackenduniremington2026.service;

import com.proyectobbackenduniremington2026.model.Donacion;
import com.proyectobbackenduniremington2026.repository.DonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DonacionService {

    @Autowired
    private DonacionRepository donacionRepository;

    /**
     * Guarda la donación en la base de datos.
     */
    public Donacion registrarDonacion(Donacion donacion) {
        // Aquí podrías añadir lógica extra, como validar el monto mínimo
        return donacionRepository.save(donacion);
    }

    /**
     * Lista todas las donaciones registradas.
     */
    public List<Donacion> listarTodas() {
        return donacionRepository.findAll();
    }
}