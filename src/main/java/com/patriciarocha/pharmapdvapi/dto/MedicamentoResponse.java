package com.patriciarocha.pharmapdvapi.dto;

import com.patriciarocha.pharmapdvapi.model.TipoMedicamento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class MedicamentoResponse {


    private Integer nroRegistro;
    private String nome;
    private String laboratorio;
    private String dosagem;
    private String descricao;
    private Float preco;
    private String tipo;
}
