package com.patriciarocha.pharmapdvapi.service;


import com.patriciarocha.pharmapdvapi.exception.RegistroJaExisteException;
import com.patriciarocha.pharmapdvapi.exception.RegistroNaoEncontradoException;
import com.patriciarocha.pharmapdvapi.model.Medicamento;
import com.patriciarocha.pharmapdvapi.repository.MedicamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository repo;

    @Autowired
    private ModelMapper mapper;

    public List<Medicamento>consultar(){
        return repo.findAll();
    }

    public Medicamento consultar(Integer nroRegistro){
        return repo.findById(nroRegistro)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Registro", nroRegistro));
    }

    public Medicamento salvar(Medicamento medicamento){
        boolean exist = repo.existsById(medicamento.getNroRegistro());
        if(exist)
            throw new RegistroJaExisteException("Medicamento", medicamento.getNroRegistro());
        medicamento = repo.save(medicamento);
        return medicamento;
    }

}
