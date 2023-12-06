package com.patriciarocha.pharmapdvapi.service;

import com.patriciarocha.pharmapdvapi.model.Estoque;
import com.patriciarocha.pharmapdvapi.model.Farmacia;
import com.patriciarocha.pharmapdvapi.model.Medicamento;
import com.patriciarocha.pharmapdvapi.repository.EstoqueRepository;
import com.patriciarocha.pharmapdvapi.repository.FarmaciaRepository;
import com.patriciarocha.pharmapdvapi.repository.MedicamentoRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class InicializacaoService {

    @Autowired
    private FarmaciaRepository farmaciaRepo;

    @Autowired
    private MedicamentoRepository medicamentoRepo;

    @Autowired
    private EstoqueRepository estoqueRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Farmacia savePharmacy(Farmacia farmacia) {

        Farmacia farmaciaNova = farmaciaRepo.save(farmacia);
        return farmaciaNova;

    }
}
