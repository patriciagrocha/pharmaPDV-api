package com.patriciarocha.pharmapdvapi.dto;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class EstoqueRequest {


    @NotNull(message = "Campo obrigatório!")
    private Long cnpj;

    @NotNull(message = "Campo obrigatório!")
    private Integer nroRegistro;

    @NotNull(message = "Campo obrigatório!" )
    @Positive(message = "A quantidade deve ser um número positivo maior que zero")
    @Digits(integer = 10, fraction = 0, message = "O número deve ter no máximo 10 dígitos")
    private Integer quantidade;

}
