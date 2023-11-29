package com.patriciarocha.pharmapdvapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Endereco endereco;


}
