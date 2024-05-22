package com.company.lunna.entitys.fichaMed;

import com.company.lunna.entitys.comidasAlergicas.ComidasAlergicas;
import com.company.lunna.entitys.endereco.Endereco;
import com.company.lunna.entitys.tratamentoMed.TratamentoMed;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
