package com.patriciarocha.pharmapdvapi.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class QuantidadeIndisponivelException extends RuntimeException {

    private String nome;
    private String identificador;
    public QuantidadeIndisponivelException(String nome, Integer identificador) {
        this(nome, identificador.toString());

    }
    public String getMessage() {
        if (nome == null || identificador == null)
            return null;
        return String.format(" Quantidade %s indisponível no %s.", identificador, nome);
    }

}
