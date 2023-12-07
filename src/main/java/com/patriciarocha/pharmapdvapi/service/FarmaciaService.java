package com.patriciarocha.pharmapdvapi.service;

import com.patriciarocha.pharmapdvapi.exception.RegistroJaExisteException;
import com.patriciarocha.pharmapdvapi.exception.RegistroNaoEncontradoException;
import com.patriciarocha.pharmapdvapi.model.Farmacia;
import com.patriciarocha.pharmapdvapi.model.Medicamento;
import com.patriciarocha.pharmapdvapi.repository.FarmaciaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmaciaService {

    @Autowired
    private FarmaciaRepository repo;

    @Autowired
    private ModelMapper mapper;

    public List<Farmacia> consultar(){
        return repo.findAll();
    }

    public Farmacia consultar(Long cnpj){
        return repo.findById(cnpj)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Registro", cnpj));
    }

    public Farmacia salvar(Farmacia farmacia){
        boolean exist = repo.existsById(farmacia.getCnpj());
        if(exist)
            throw new RegistroJaExisteException("Farmácia", farmacia.getCnpj());
        farmacia = repo.save(farmacia);
        return farmacia;
    }


}
