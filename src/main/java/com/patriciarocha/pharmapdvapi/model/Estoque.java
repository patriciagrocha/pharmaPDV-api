package com.patriciarocha.pharmapdvapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ESTOQUES")
@IdClass(IdEstoque.class)
public class Estoque {

    @Id
    @Column(name = "CNPJ", nullable = false)
    private Long cnpj;

    @Id
    @Column(name = "nro_registro")
    private Integer nroRegistro;

    private Integer quantidade;

    private LocalDateTime dataAtualizacao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return Objects.equals(cnpj, estoque.cnpj) && Objects.equals(nroRegistro, estoque.nroRegistro) && Objects.equals(quantidade, estoque.quantidade) && Objects.equals(dataAtualizacao, estoque.dataAtualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj, nroRegistro, quantidade, dataAtualizacao);
    }
}
