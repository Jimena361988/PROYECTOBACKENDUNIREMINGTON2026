package com.proyectobbackenduniremington2026.service;

import com.proyectobbackenduniremington2026.model.Beneficiario;
import com.proyectobbackenduniremington2026.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository repository;

    public Beneficiario guardar(Beneficiario beneficiario) {
        return repository.save(beneficiario);
    }

    public List<Beneficiario> guardarTodo(List<Beneficiario> beneficiarios) {
        return repository.saveAll(beneficiarios);
    }

    public List<Beneficiario> listar() {
        return repository.findAll();
    }

    public Optional<Beneficiario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Beneficiario> buscarPorDocumento(String documento) {
        return repository.findByDocumento(documento);
    }

    public Beneficiario actualizar(Long id, Beneficiario datos) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setNombre(datos.getNombre());
                    existing.setApellido(datos.getApellido());
                    existing.setDocumento(datos.getDocumento());
                    existing.setTelefono(datos.getTelefono());
                    existing.setEdad(datos.getEdad());
                    existing.setGenero(datos.getGenero());
                    existing.setMunicipio(datos.getMunicipio());
                    existing.setBarrio(datos.getBarrio());
                    existing.setPoblacion(datos.getPoblacion());
                    existing.setServicio(datos.getServicio());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new IllegalArgumentException("Beneficiario no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Beneficiario no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }
}
