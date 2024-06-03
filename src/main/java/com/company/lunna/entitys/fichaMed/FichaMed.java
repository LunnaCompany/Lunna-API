package com.company.lunna.entitys.fichaMed;


import com.company.lunna.entitys.enderecoHospital.EnderecoHospital;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "FICHA_MED")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichaMed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String planSaud;

    private String cuidados;

    @Column(nullable = false)
    private String numCartSus;

    private String remedios;

    private String comidasAlergicas;

    private String descTratamento;

    private Integer qtdHoraMed;

    private Float qtdMed;

    @Column(nullable = false)
    private EnderecoHospital endereco;

}
