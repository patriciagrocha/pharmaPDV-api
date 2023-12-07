package com.patriciarocha.pharmapdvapi.dto;

import com.patriciarocha.pharmapdvapi.model.Endereco;
import jakarta.persistence.Embedded;
import lombok.Data;

@Data
public class FarmaciaResponse {

    private Long cnpj;

    private String razaoSocial;

    private String nomeFantasia;

    private String email;

    private String telefone;

    private String celular;

    @Embedded
    private Endereco endereco;

}
