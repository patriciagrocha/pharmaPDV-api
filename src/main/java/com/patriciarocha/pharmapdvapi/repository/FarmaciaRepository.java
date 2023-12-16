package com.patriciarocha.pharmapdvapi.repository;

import com.patriciarocha.pharmapdvapi.model.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {
    Boolean existsByCnpj(Long cnpj);
}
