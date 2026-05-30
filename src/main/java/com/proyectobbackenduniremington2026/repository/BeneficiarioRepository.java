package com.proyectobbackenduniremington2026.repository;

import com.proyectobbackenduniremington2026.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
    /**
     * Busca un beneficiario por su número de documento.
     *
     * @param documento documento del beneficiario
     * @return Optional con el beneficiario o vacío si no existe
     */
    Optional<Beneficiario> findByDocumento(String documento);
}