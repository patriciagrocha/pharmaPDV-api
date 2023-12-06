package com.patriciarocha.pharmapdvapi.controller;


import com.patriciarocha.pharmapdvapi.dto.MedicamentoResponse;
import com.patriciarocha.pharmapdvapi.model.Medicamento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<MedicamentoResponse>> consultar() {
        List<Medicamento> medicamentos = service.consultar();
        List<MedicamentoResponse> resp = new ArrayList<>();
        for (Medicamento medicamento : medicamentos) {
            MedicamentoResponse medResp = mapper.map(medicamento, MedicamentoResponse.class);
            resp.add(medResp);
        }
        return ResponseEntity.ok(resp);
    }
    @GetMapping("/{nroRegistro}")
    public ResponseEntity<MedicamentoResponse> consultar(@PathVariable("nroRegistro") Integer nroRegistro) {
        Medicamento medicamento = service.consultar(nroRegistro);
        MedicamentoResponse resp = mapper.map(medicamento, MedicamentoResponse.class);
        return ResponseEntity.ok(resp);
    }



}
