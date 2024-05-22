package com.company.lunna.entity.tratamentoMed;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "TRATAMENTO_MED")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TratamentoMed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tratamento;

    @Column(nullable = false)
    private String descTratamento;
}
