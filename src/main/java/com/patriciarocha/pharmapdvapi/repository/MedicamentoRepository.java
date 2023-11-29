package com.patriciarocha.pharmapdvapi.repository;

import com.patriciarocha.pharmapdvapi.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {
    Boolean existsByNroRegistro(Integer nroRegistro);
}
