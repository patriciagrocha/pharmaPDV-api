package com.patriciarocha.pharmapdvapi.controller;


import com.patriciarocha.pharmapdvapi.dto.EstoqueRequest;
import com.patriciarocha.pharmapdvapi.dto.EstoqueResponse;
import com.patriciarocha.pharmapdvapi.dto.EstoqueTransferenciaRequest;
import com.patriciarocha.pharmapdvapi.dto.EstoqueTransferenciaResponse;
import com.patriciarocha.pharmapdvapi.model.Estoque;
import com.patriciarocha.pharmapdvapi.service.EstoqueService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @Autowired
    private ModelMapper mapper;


    @GetMapping
    public ResponseEntity<List<EstoqueResponse>> consultar() {
        List<Estoque> estoqueList = service.consultar();
        List<EstoqueResponse> resp = new ArrayList<>();
        for (Estoque estoque : estoqueList) {
            EstoqueResponse estoqueResp = mapper.map(estoque, EstoqueResponse.class);
            resp.add(estoqueResp);
        }
        return ResponseEntity.ok(resp);
    }
    @GetMapping("/{cnpj}")
    public ResponseEntity<List<EstoqueResponse>> consultar(@PathVariable("cnpj") Long cnpj) {
        var estoquesCnpj = service.consultar(cnpj);
        return ResponseEntity.ok(estoquesCnpj);
    }

    @PostMapping
    public ResponseEntity<EstoqueResponse> criar(@RequestBody @Valid EstoqueRequest request) {
        Estoque estoque = mapper.map(request, Estoque.class);
        estoque = service.salvar(estoque);

        var resp = mapper.map(estoque, EstoqueResponse.class);
        return ResponseEntity.ok(resp);
        //return ResponseEntity.created(URI.create(estoque.getCnpj().toString())).body(resp);

    }

    @DeleteMapping
    public ResponseEntity<EstoqueResponse> excluir(@RequestBody @Valid EstoqueRequest request){
        Estoque estoque = mapper.map(request, Estoque.class);
        estoque = service.excluir(estoque);
        var resp = mapper.map(estoque, EstoqueResponse.class);
        return ResponseEntity.ok(resp);
    }
    @PutMapping
    public ResponseEntity<EstoqueTransferenciaResponse> atualizar(@RequestBody @Valid EstoqueTransferenciaRequest request) {
        var estoque = service.atualizar(request);
        return ResponseEntity.ok(estoque);
    }

}
