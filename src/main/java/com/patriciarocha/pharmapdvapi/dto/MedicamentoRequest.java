package com.patriciarocha.pharmapdvapi.dto;

import com.patriciarocha.pharmapdvapi.model.TipoMedicamento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

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
    @Enumerated(EnumType.STRING)
    private TipoMedicamento tipo;
}
