package com.patriciarocha.pharmapdvapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class EstoqueRequest {


    @NotNull(message = "Campo obrigatório!")
    private Long cnpj;

    @NotNull(message = "Campo obrigatório!")
    private Integer nroRegistro;

    @Min(value = 1, message = "A quantidade deve ser um número positivo maior que zero")
    private Integer quantidade;

}
