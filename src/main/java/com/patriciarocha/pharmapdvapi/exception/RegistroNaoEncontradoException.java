package com.patriciarocha.pharmapdvapi.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RegistroNaoEncontradoException extends RuntimeException {

    private String nome;
    private String identificador;


    public RegistroNaoEncontradoException(String nome, Integer identificador) {
        this(nome, identificador.toString());
    }

    public RegistroNaoEncontradoException(String nome, Long identificador) {
        this(nome, identificador.toString());
    }


    public String getMessage() {
        if (nome == null || identificador == null)
            return null;
        return String.format(" %s não encontrado com identificador '%s'", nome, identificador);
    }

}
