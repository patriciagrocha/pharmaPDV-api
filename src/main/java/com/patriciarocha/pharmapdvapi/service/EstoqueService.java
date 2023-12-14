package com.patriciarocha.pharmapdvapi.service;

import com.patriciarocha.pharmapdvapi.dto.EstoqueResponse;
import com.patriciarocha.pharmapdvapi.exception.RegistroNaoEncontradoException;
import com.patriciarocha.pharmapdvapi.model.Estoque;
import com.patriciarocha.pharmapdvapi.model.Farmacia;
import com.patriciarocha.pharmapdvapi.model.Medicamento;
import com.patriciarocha.pharmapdvapi.repository.EstoqueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository repo;

    @Autowired
    private FarmaciaService farmaciaService;

    @Autowired
    private  MedicamentoService medicamentoService;

    @Autowired
    private ModelMapper mapper;

    public List<Estoque>consultar(){
        return repo.findAll();
    }

    public List<EstoqueResponse> consultar(Long cnpj){

        List<Estoque> estoqueList = repo.findAllByCnpj(cnpj);
        if (estoqueList.isEmpty()) {
            throw new RegistroNaoEncontradoException("Registro", cnpj);
        }
        List<EstoqueResponse> estoqueRespList = new ArrayList<>();
        for(Estoque estoque : estoqueList){
            Medicamento medicamento = medicamentoService.consultar(estoque.getNroRegistro());
            EstoqueResponse estoqueResp = mapper.map(estoque, EstoqueResponse.class);
            estoqueResp.setNome(medicamento.getNome());
            estoqueRespList.add(estoqueResp);
        }
        return estoqueRespList;
    }

    public Estoque salvar(Estoque estoque) {

        Long cnpj = estoque.getCnpj();
        Farmacia farmacia = farmaciaService.consultar(cnpj);

        Integer nroRegistro = estoque.getNroRegistro();
        Medicamento medicamento = medicamentoService.consultar(nroRegistro);

        if (!repo.existsByCnpjAndNroRegistro(estoque.getCnpj(), estoque.getNroRegistro())){
            estoque = repo.save(estoque);
            return estoque;
        }

        Estoque estoqueBD = repo.findByCnpjAndNroRegistro(cnpj, nroRegistro);
        estoque.setQuantidade(estoqueBD.getQuantidade() + estoque.getQuantidade());
        estoque = repo.save(estoque);
        return estoque;

    }
}







