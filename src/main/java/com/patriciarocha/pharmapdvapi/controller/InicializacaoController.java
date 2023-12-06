package com.patriciarocha.pharmapdvapi.controller;

import com.patriciarocha.pharmapdvapi.model.Endereco;
import com.patriciarocha.pharmapdvapi.model.Farmacia;
import com.patriciarocha.pharmapdvapi.service.InicializacaoService;
import org.antlr.v4.runtime.misc.LogManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/inicializacao")
public class InicializacaoController {

   @Autowired
   private InicializacaoService service;

    @Autowired
    private ModelMapper mapper;


    @PostMapping
    public ResponseEntity<?> savePharmacy(){

        Endereco endereco1 = new Endereco(8877799L,"Rua Madrid",76,"Winterfell", "Estocolmo",
                "SC","", 19.254356, 3.8987687);

        Farmacia farmacia1 = new Farmacia(43178995000198L,"MedHouse Ltda","Farmácia MedHouse",
                "medhouse@farmacia.com", "(55)5555-5555","(45)95555-5555",endereco1 );

        var service = mapper.map(farmacia1, InicializacaoService.class);
        service.savePharmacy(farmacia1);
        return new ResponseEntity<>(HttpStatus.CREATED);





    }
}
