package com.company.lunna.entitys.discente;

import com.company.lunna.entitys.contatoEmergencia.ContatoEmergencia;
import com.company.lunna.entitys.deficiencia.Deficiencia;
import com.company.lunna.entitys.fichaMed.FichaMed;
import com.company.lunna.entitys.momento.Momento;
import com.company.lunna.entitys.responsavel.Responsavel;
import com.company.lunna.entitys.turma.Turma;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "DISCENTE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Discente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDisc;

    @Column(nullable = false)
    private String cpfDisc;

    @Column(nullable = false)
    private String nomeDisc;

    @Column(nullable = false)
    private LocalDate dataNasDisc;

    @Column(nullable = false)
    private Float alturaDisc;

    @Column(nullable = false)
    private Float pesoDisc;

    @Column(nullable = false)
    private String imgDisc;

    private String deficiencia;

    @ManyToOne
    @JoinColumn(name = "id_ficha_med")
    @JsonBackReference
    private FichaMed fichaMed;

    @ManyToOne
    @JoinColumn(name = "id_contato_emergencia")
    private ContatoEmergencia contato;

    @ManyToOne
    @JoinColumn(name = "id_momento")
    private Momento idMomento;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    @JsonBackReference
    private Turma turma;

    @ManyToMany
    @JoinTable(
            name = "responsavel_discente",
            joinColumns = @JoinColumn(name = "id_disc"),
            inverseJoinColumns = @JoinColumn(name = "id_resp")
    )
    @JsonManagedReference
    List<Responsavel> responsaveis;
}
