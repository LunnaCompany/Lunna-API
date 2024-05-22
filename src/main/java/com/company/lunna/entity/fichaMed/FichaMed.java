package com.company.lunna.entity.fichaMed;

import com.company.lunna.entity.comidasAlergicas.ComidasAlergicas;
import com.company.lunna.entity.endereco.Endereco;
import com.company.lunna.entity.tratamentoMed.TratamentoMed;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "FICHA_MED")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichaMed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String planSaud;

    @Column(nullable = false)
    private String tipSang;

    @Column(nullable = false)
    private String observacoes;

    private String numCartSus;

    @Column(nullable = false)
    private Double nConvenio;

    @Column(nullable = false)
    private Endereco endereco;

    private String remedios;

    @ManyToOne
    @JoinColumn(name = "id_tratamento")
    private TratamentoMed idTratamento;

    @ManyToOne
    @JoinColumn(name = "id_comidas")
    private ComidasAlergicas idComidas;
}
