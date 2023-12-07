package com.patriciarocha.pharmapdvapi.service;

import com.patriciarocha.pharmapdvapi.exception.RegistroNaoEncontradoException;
import com.patriciarocha.pharmapdvapi.model.Estoque;
import com.patriciarocha.pharmapdvapi.repository.EstoqueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository repo;

    @Autowired
    private ModelMapper mapper;

    public List<Estoque>consultar(){
        return repo.findAll();
    }

    public List<Estoque> consultar(Long cnpj){

        List<Estoque> estoques = repo.findAllByCnpj(cnpj);

        if (estoques.isEmpty()) {
            throw new RegistroNaoEncontradoException("Registro", cnpj);
        }
        return estoques;

    }
}







