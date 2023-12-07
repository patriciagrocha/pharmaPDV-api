package com.patriciarocha.pharmapdvapi.service;

import com.patriciarocha.pharmapdvapi.exception.RegistroJaExisteException;
import com.patriciarocha.pharmapdvapi.model.*;
import com.patriciarocha.pharmapdvapi.repository.EstoqueRepository;
import com.patriciarocha.pharmapdvapi.repository.FarmaciaRepository;
import com.patriciarocha.pharmapdvapi.repository.MedicamentoRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class InicializacaoService {

    @Autowired
    private FarmaciaRepository farmaciaRepo;

    @Autowired
    private MedicamentoRepository medicamentoRepo;

    @Autowired
    private EstoqueRepository estoqueRepo;


    public void salvar(){

        // Inicialização de Farmácias
        Endereco endereco1 = new Endereco(8877799L,"Rua Madrid",76,"Winterfell", "Estocolmo",
                "SC","", 19.254356, 3.8987687);
        Farmacia farmacia1 = new Farmacia(43178995000198L,"MedHouse Ltda","Farmácia MedHouse",
                "medhouse@farmacia.com", "(55)5555-5555","(45)95555-5555",endereco1 );


        Endereco endereco2 = new Endereco(88888999L,"Rua Porto Real",67,"Westeros","Berlim",
                "SC","", 15.23456, 2.8678687);
        Farmacia farmacia2 = new Farmacia(90561736000121L,"DevMed Ltda","Farmácia DevMed","devmed@farmacia.com",
                "(44)4444-4444","(44)9444-4441",endereco2);

        // Inicialização de medicamentos

        Medicamento medicamento1 = new Medicamento(1010," Programapan","Matrix","2x ao dia",
                " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend",
                111.00, TipoMedicamento.COMUM);

        Medicamento medicamento2 = new Medicamento(7473, "Cafex", "Colombia Farm", "4x ao dia",
                "Pellentesque non ultricies mauris, ut lobortis elit. Cras nec cursus nibh",
                51.50, TipoMedicamento.COMUM);

        Medicamento medicamento3 = new Medicamento(2233, "Estomazol", "Acme", "1x ao dia",
                "Sed risus mauris, consectetur eget egestas vitae", 22.50, TipoMedicamento.COMUM);


        Medicamento medicamento4 = new Medicamento(5656, "Aspirazol", "Acme", "3x ao dia",
                "Sed faucibus, libero iaculis pulvinar consequat, augue elit eleifend", 10.50, TipoMedicamento.CONTROLADO);

        Medicamento medicamento5 = new Medicamento(4040, "Propolizol", "Bee", "5x ao dia",
                "Nunc euismod ipsum purus, sit amet finibus libero ultricies in", 10.50, TipoMedicamento.CONTROLADO);

        Medicamento medicamento6 = new Medicamento(8880, "Gelox", "Ice", "2x ao dia",
                "Quisque quam orci, vulputate sit amet", 11.50, TipoMedicamento.COMUM);


        // Inicialização de estoque

        Estoque estoque1 = new Estoque(90561736000121L, 1010, 12, LocalDateTime.now());
        Estoque estoque2 = new Estoque(90561736000121L, 7473, 10, LocalDateTime.now());
        Estoque estoque3 = new Estoque(43178995000198L, 7473, 2, LocalDateTime.now());
        Estoque estoque4 = new Estoque(43178995000198L, 2233,15, LocalDateTime.now());
        Estoque estoque5 = new Estoque(43178995000198L, 8880, 16, LocalDateTime.now());
        Estoque estoque6 = new Estoque(43178995000198L, 4040,22, LocalDateTime.now());


        farmaciaRepo.save(farmacia1);
        farmaciaRepo.save(farmacia2);
        medicamentoRepo.save(medicamento1);
        medicamentoRepo.save(medicamento2);
        medicamentoRepo.save(medicamento3);
        medicamentoRepo.save(medicamento4);
        medicamentoRepo.save(medicamento5);
        medicamentoRepo.save(medicamento6);
        estoqueRepo.save(estoque1);
        estoqueRepo.save(estoque2);
        estoqueRepo.save(estoque3);
        estoqueRepo.save(estoque4);
        estoqueRepo.save(estoque5);
        estoqueRepo.save(estoque6);

    }

}



