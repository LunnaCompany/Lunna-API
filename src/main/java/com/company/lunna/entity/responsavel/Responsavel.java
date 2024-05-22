package com.company.lunna.entity.responsavel;

import com.company.lunna.entity.discente.Discente;
import com.company.lunna.entity.endereco.Endereco;
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

    @Embedded
    private Endereco enderecoResp;

    @Column(nullable = false)
    private String emailResp;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String profissaoResp;

    @Column(nullable = false)
    private String estadoCivilResp;


    @ManyToMany(mappedBy = "responsaveis")
    List<Discente> discentes;
}
