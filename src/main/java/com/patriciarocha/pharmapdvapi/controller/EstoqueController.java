package com.patriciarocha.pharmapdvapi.controller;


import com.patriciarocha.pharmapdvapi.dto.EstoqueResponse;
import com.patriciarocha.pharmapdvapi.model.Estoque;
import com.patriciarocha.pharmapdvapi.service.EstoqueService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estoque")
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
        List<EstoqueResponse> estoques = service.consultar(cnpj);
        List<EstoqueResponse> resp = estoques.stream()
                .map(estoque -> mapper.map(estoque, EstoqueResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(resp);
    }


}
