package com.patriciarocha.pharmapdvapi.repository;

import com.patriciarocha.pharmapdvapi.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
