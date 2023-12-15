package com.patriciarocha.pharmapdvapi.service;

import com.patriciarocha.pharmapdvapi.dto.EstoqueResponse;
import com.patriciarocha.pharmapdvapi.dto.EstoqueTransferenciaRequest;
import com.patriciarocha.pharmapdvapi.dto.EstoqueTransferenciaResponse;
import com.patriciarocha.pharmapdvapi.exception.QuantidadeIndisponivelException;
import com.patriciarocha.pharmapdvapi.exception.RegistroNaoEncontradoException;
import com.patriciarocha.pharmapdvapi.model.*;
import com.patriciarocha.pharmapdvapi.repository.EstoqueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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

        if (repo.existsByCnpjAndNroRegistro(cnpj, nroRegistro)){
            Estoque estoqueBD = repo.findByCnpjAndNroRegistro(cnpj, nroRegistro);
            estoque.setQuantidade(estoqueBD.getQuantidade() + estoque.getQuantidade());
        }
        estoque.setDataAtualizacao(LocalDateTime.now());
        estoque = repo.save(estoque);
        return estoque;

    }
    public Estoque excluir(Estoque estoque) {

        Long cnpj = estoque.getCnpj();
        Farmacia farmacia = farmaciaService.consultar(cnpj);
        Integer nroRegistro = estoque.getNroRegistro();
        Medicamento medicamento = medicamentoService.consultar(nroRegistro);

        if (repo.existsByCnpjAndNroRegistro(cnpj, nroRegistro)){
            Estoque estoqueBD = repo.findByCnpjAndNroRegistro(cnpj, nroRegistro);
            var estoqueQtdBD = estoqueBD.getQuantidade();

            if(estoqueQtdBD < estoque.getQuantidade())
                throw new QuantidadeIndisponivelException("Estoque", estoque.getQuantidade());

            estoque.setQuantidade(estoqueBD.getQuantidade() - estoque.getQuantidade());
            estoque.setDataAtualizacao(LocalDateTime.now());
            estoque = repo.save(estoque);
        }

        if(estoque.getQuantidade() == 0)
            repo.delete(estoque);

        return estoque;

    }
    @Transactional
    public EstoqueTransferenciaResponse atualizar(EstoqueTransferenciaRequest request) {
        farmaciaService.consultar(request.getCnpjOrigem());
        farmaciaService.consultar(request.getCnpjDestino());
        medicamentoService.consultar(request.getNroRegistro());

        if (!repo.existsByCnpjAndNroRegistro(request.getCnpjOrigem(), request.getNroRegistro())) {
            throw new RegistroNaoEncontradoException("Estoque de Medicamento na Farmácia de Origem", request.getNroRegistro());
        }

        Estoque estoqueOrigem = repo.findByCnpjAndNroRegistro(request.getCnpjOrigem(), request.getNroRegistro());
        Estoque estoqueDestino = repo.findByCnpjAndNroRegistro(request.getCnpjDestino(), request.getNroRegistro());

        if (estoqueOrigem.getQuantidade() < request.getQuantidade())
            throw new QuantidadeIndisponivelException("Estoque de origem", request.getQuantidade());

        estoqueOrigem.setQuantidade(estoqueOrigem.getQuantidade() - request.getQuantidade());
        estoqueOrigem.setDataAtualizacao(LocalDateTime.now());
        repo.save(estoqueOrigem);

        estoqueDestino.setQuantidade(estoqueDestino.getQuantidade() + request.getQuantidade());
        estoqueDestino.setDataAtualizacao(LocalDateTime.now());
        repo.save(estoqueDestino);

        if(estoqueOrigem.getQuantidade() == 0 )
            repo.delete(estoqueOrigem);

        var resp = new EstoqueTransferenciaResponse();
        resp.setNroRegistro(request.getNroRegistro());
        resp.setCnpjOrigem(request.getCnpjOrigem());
        resp.setQuantidadeOrigem(estoqueOrigem.getQuantidade());
        resp.setCnpjDestino(request.getCnpjDestino());
        resp.setQuantidadeDestino(estoqueDestino.getQuantidade());

        return resp;
    }

}







