package com.proyectobbackenduniremington2026.service;

import com.proyectobbackenduniremington2026.repository.ServicioPrestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndicadorService {

    @Autowired
    private ServicioPrestadoRepository servicioRepo;

    /**
     * Mapea los resultados del conteo JPQL por cobertura (Municipios)
     */
    public Map<String, Long> obtenerDatosCobertura() {
        List<Object[]> resultados = servicioRepo.countByCobertura();
        Map<String, Long> mapaCobertura = new HashMap<>();

        for (Object[] fila : resultados) {
            String municipio = (String) fila[0];
            Long cantidad = (Long) fila[1];
            mapaCobertura.put(municipio, cantidad);
        }
        return mapaCobertura;
    }

    /**
     * Entrega las métricas requeridas por el controlador para el Dashboard
     */
    public Map<String, Object> getDashboardCompleto() {
        Map<String, Object> dashboard = new HashMap<>();
        dashboard.put("cobertura", obtenerDatosCobertura());
        dashboard.put("totalServicios", servicioRepo.count());
        return dashboard;
    }
}