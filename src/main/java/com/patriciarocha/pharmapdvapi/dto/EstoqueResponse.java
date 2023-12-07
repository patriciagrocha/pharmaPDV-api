package com.patriciarocha.pharmapdvapi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EstoqueResponse {

    private Integer nroRegistro;
    private String nome;
    private Integer quantidade;
    private LocalDateTime dataAtualizacao;

//    public EstoqueResponse(Integer nroRegistro, Medicamento nome, Integer quantidade, LocalDateTime dataAtualizacao) {
//        this.nroRegistro = nroRegistro;
//        this.nome = nome;
//        this.quantidade = quantidade;
//        this.dataAtualizacao = dataAtualizacao;
//    }


}
