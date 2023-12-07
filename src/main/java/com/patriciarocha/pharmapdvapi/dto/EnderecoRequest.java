package com.patriciarocha.pharmapdvapi.dto;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Embeddable
public class EnderecoRequest {

    @NotNull(message = "Campo obrigatório!")
    private Long cep;

    @NotEmpty(message = "Campo obrigatório!")
    private String logradouro;

    @NotNull(message = "Campo obrigatório!")
    private Integer numero;

    @NotEmpty(message = "Campo obrigatório!")
    private String bairro;

    @NotEmpty(message = "Campo obrigatório!")
    private String cidade;

    @NotEmpty(message = "Campo obrigatório!")
    private String estado;


    private String complemento;

    @NotNull(message = "Campo obrigatório!")
    private Double latitude;

    @NotNull(message = "Campo obrigatório!")
    private Double longitude;
}
