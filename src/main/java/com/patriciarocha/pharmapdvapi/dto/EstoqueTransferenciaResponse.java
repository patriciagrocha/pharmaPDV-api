package com.patriciarocha.pharmapdvapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueTransferenciaResponse {

    private Integer nroRegistro;

    private Long cnpjOrigem;

    private Integer quantidadeOrigem;

    private Long cnpjDestino;

    private Integer quantidadeDestino;
}
