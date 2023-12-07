package com.patriciarocha.pharmapdvapi.controller;

import com.patriciarocha.pharmapdvapi.dto.FarmaciaRequest;
import com.patriciarocha.pharmapdvapi.dto.FarmaciaResponse;
import com.patriciarocha.pharmapdvapi.model.Farmacia;
import com.patriciarocha.pharmapdvapi.service.FarmaciaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/farmacias")
public class FarmaciaController {

    @Autowired
    private FarmaciaService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<FarmaciaResponse>> consultar() {
        List<Farmacia> farmacias = service.consultar();
        List<FarmaciaResponse> resp = new ArrayList<>();
        for (Farmacia farmacia : farmacias) {
            FarmaciaResponse farmaResp = mapper.map(farmacia, FarmaciaResponse.class);
            resp.add(farmaResp);
        }
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<FarmaciaResponse> consultar(@PathVariable("cnpj") Long cnpj) {
        Farmacia farmacia = service.consultar(cnpj);
        FarmaciaResponse resp = mapper.map(farmacia, FarmaciaResponse.class);
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<FarmaciaResponse> criar(@RequestBody @Valid FarmaciaRequest request) {
        var farmacia = mapper.map(request, Farmacia.class);
        farmacia = service.salvar(farmacia);
        var resp = mapper.map(farmacia, FarmaciaResponse.class);
        return ResponseEntity.created(URI.create(farmacia.getCnpj().toString())).body(resp);
    }

}
