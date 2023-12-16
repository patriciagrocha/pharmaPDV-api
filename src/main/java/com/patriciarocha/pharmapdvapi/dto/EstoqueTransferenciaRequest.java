package com.patriciarocha.pharmapdvapi.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueTransferenciaRequest {

    @NotNull(message = "CNPJ de origem obrigatório")
    private Long cnpjOrigem;

    @NotNull(message = "CNPJ de destino obrigatório")
    private Long cnpjDestino;

    @NotNull(message = "Número de registro obrigatório")
    private Integer nroRegistro;

    @NotNull(message = "Quantidade obrigatório!" )
    @Positive(message = "A quantidade deve ser um número positivo maior que zero")
    @Digits(integer = 10, fraction = 0, message = "O número deve ter no máximo 10 dígitos")
    private Integer quantidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstoqueTransferenciaRequest that = (EstoqueTransferenciaRequest) o;
        return Objects.equals(cnpjOrigem, that.cnpjOrigem) && Objects.equals(cnpjDestino, that.cnpjDestino) && Objects.equals(nroRegistro, that.nroRegistro) && Objects.equals(quantidade, that.quantidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpjOrigem, cnpjDestino, nroRegistro, quantidade);
    }
}
