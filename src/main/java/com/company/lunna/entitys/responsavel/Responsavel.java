package com.company.lunna.entitys.responsavel;

import com.company.lunna.entitys.contato.Contato;
import com.company.lunna.entitys.discente.Discente;
import com.company.lunna.entitys.endereco.Endereco;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(nullable = false, unique = true)
    private String cpfResp;

    @Column(nullable = false)
    private String rgResp;

    @Column(nullable = false, unique = true)
    private String emailResp;

    @Column(nullable = false)
    private String emailRecResp;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String ftRgResp;

    @Column(nullable = false)
    private String ftPerfilResp;

    @Embedded
    private Contato contato;

    @Embedded
    private Endereco enderecoResp;

    @ManyToMany(mappedBy = "responsaveis")
    @JsonBackReference
    List<Discente> discentes;
}
