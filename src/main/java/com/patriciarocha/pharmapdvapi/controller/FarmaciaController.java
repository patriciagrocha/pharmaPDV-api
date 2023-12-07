package com.patriciarocha.pharmapdvapi.controller;

import com.patriciarocha.pharmapdvapi.dto.FarmaciaResponse;
import com.patriciarocha.pharmapdvapi.dto.MedicamentoResponse;
import com.patriciarocha.pharmapdvapi.model.Farmacia;
import com.patriciarocha.pharmapdvapi.model.Medicamento;
import com.patriciarocha.pharmapdvapi.service.FarmaciaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
