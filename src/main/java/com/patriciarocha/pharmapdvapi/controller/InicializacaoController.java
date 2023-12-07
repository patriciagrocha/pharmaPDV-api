package com.patriciarocha.pharmapdvapi.controller;

import com.patriciarocha.pharmapdvapi.dto.MedicamentoResponse;
import com.patriciarocha.pharmapdvapi.model.Endereco;
import com.patriciarocha.pharmapdvapi.model.Farmacia;
import com.patriciarocha.pharmapdvapi.model.Medicamento;
import com.patriciarocha.pharmapdvapi.service.InicializacaoService;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.misc.LogManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/inicializacao")
public class InicializacaoController {

   @Autowired
   private InicializacaoService service;

    @Autowired
    private ModelMapper mapper;
    @PostMapping
    public ResponseEntity<?> salvar(){
            service.salvar();
            return ResponseEntity.ok().build();

    }
}
