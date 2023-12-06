package com.patriciarocha.pharmapdvapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="MEDICAMENTOS")
public class Medicamento {

    @Id
    private Integer nroRegistro;
    private String nome;
    private String laboratorio;
    private String dosagem;
    private String descricao;
    private Float preco;
    @Enumerated(EnumType.STRING)
    private TipoMedicamento tipo;

    public Medicamento(Integer nroRegistro) {
        this.nroRegistro = nroRegistro;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "nroRegistro=" + nroRegistro +
                ", nome='" + nome + '\'' +
                ", laboratorio='" + laboratorio + '\'' +
                ", dosagem='" + dosagem + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", tipo=" + tipo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicamento that = (Medicamento) o;
        return Objects.equals(nroRegistro, that.nroRegistro);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nroRegistro, nome, laboratorio, dosagem, descricao, preco, tipo);
    }
}
