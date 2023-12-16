package com.patriciarocha.pharmapdvapi.repository;

import com.patriciarocha.pharmapdvapi.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    List<Estoque> findAllByCnpj(Long cnpj);
    boolean existsByCnpjAndNroRegistro(Long cnpj, Integer nroRegistro);

    Estoque findByCnpjAndNroRegistro(Long cnpj, Integer nroRegistro);
}
