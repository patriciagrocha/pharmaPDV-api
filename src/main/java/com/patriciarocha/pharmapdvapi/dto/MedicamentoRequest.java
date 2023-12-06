package com.patriciarocha.pharmapdvapi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MedicamentoRequest {

    @NotNull(message = "Campo obrigatório: Número de registro")
    private Integer nroRegistro;

    @NotEmpty(message = "Campo obrigatório!")
    private String nome;

    @NotEmpty(message = "Campo obrigatório!")
    private String laboratorio;

    @NotEmpty(message = "Campo obrigatório!")
    private String dosagem;

    @NotEmpty(message = "Campo obrigatório!")
    private String descricao;

    @NotNull(message = "Campo obrigatório!")
    private Float preco;

    @NotEmpty(message = "Campo obrigatório!")
    private String tipo;
}
