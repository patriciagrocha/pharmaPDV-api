package com.patriciarocha.pharmapdvapi.dto;

import com.patriciarocha.pharmapdvapi.model.Endereco;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FarmaciaRequest {

    @NotNull(message = "Campo obrigatório!")
    private Long cnpj;

    @NotEmpty(message = "Campo obrigatório!")
    private String razaoSocial;

    @NotEmpty(message = "Campo obrigatório!")
    private String nomeFantasia;

    @NotEmpty(message = "Campo obrigatório!")
    private String email;

    @NotEmpty(message = "Campo obrigatório!")
    private String telefone;

    @NotEmpty(message = "Campo obrigatório!")
    private String celular;

    @Embedded
    @Valid
    private Endereco endereco;

}
