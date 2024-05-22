package com.company.lunna.entitys.responsavel;

import com.company.lunna.entitys.discente.Discente;
import com.company.lunna.entitys.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "RESPONSAVEL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResp;

    @Column(nullable = false)
    private String nomeResp;

    @Column(nullable = false)
    private String emailResp;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String profissaoResp;

    @Column(nullable = false)
    private String estadoCivilResp;

    @Embedded
    private Endereco enderecoResp;

    @ManyToMany(mappedBy = "responsaveis")
    List<Discente> discentes;
}
