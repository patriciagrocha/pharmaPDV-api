package com.patriciarocha.pharmapdvapi.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(cep, endereco.cep) && Objects.equals(logradouro, endereco.logradouro) && Objects.equals(numero, endereco.numero) && Objects.equals(bairro, endereco.bairro) && Objects.equals(cidade, endereco.cidade) && Objects.equals(estado, endereco.estado) && Objects.equals(complemento, endereco.complemento) && Objects.equals(latitude, endereco.latitude) && Objects.equals(longitude, endereco.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, logradouro, numero, bairro, cidade, estado, complemento, latitude, longitude);
    }
}
