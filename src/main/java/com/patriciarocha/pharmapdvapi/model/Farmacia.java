package com.patriciarocha.pharmapdvapi.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="FARMACIAS")
public class Farmacia {

    @Id
    private Long cnpj;

    private String razaoSocial;

    private String nomeFantasia;

    private String email;

    private String telefone;

    private String celular;

    @Embedded
    private Endereco endereco;

    @Override
    public String toString() {
        return "Farmacia{" +
                "cnpj=" + cnpj +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", endereco=" + endereco +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Farmacia farmacia = (Farmacia) o;
        return Objects.equals(cnpj, farmacia.cnpj) && Objects.equals(razaoSocial, farmacia.razaoSocial) && Objects.equals(nomeFantasia, farmacia.nomeFantasia) && Objects.equals(email, farmacia.email) && Objects.equals(telefone, farmacia.telefone) && Objects.equals(celular, farmacia.celular) && Objects.equals(endereco, farmacia.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj, razaoSocial, nomeFantasia, email, telefone, celular, endereco);
    }
}
