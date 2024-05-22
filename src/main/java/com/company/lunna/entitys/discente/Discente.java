package com.company.lunna.entitys.discente;

import com.company.lunna.entitys.contatoEmergencia.ContatoEmergencia;
import com.company.lunna.entitys.deficiencia.Deficiencia;
import com.company.lunna.entitys.fichaMed.FichaMed;
import com.company.lunna.entitys.momento.Momento;
import com.company.lunna.entitys.responsavel.Responsavel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "DISCENTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDisc;

    @Column(nullable = false)
    private String cpfDisc;

    @Column(nullable = false)
    private String nome_disc;

    @Column(nullable = false)
    private LocalDate dataNasDisc;

    @Column(nullable = false)
    private Float alturaDisc;

    @Column(nullable = false)
    private Float pesoDisc;

    @Column(nullable = false)
    private String imgDisc;

    @ManyToOne
    @JoinColumn(name = "id_def")
    private Deficiencia idDef;

    @ManyToOne
    @JoinColumn(name = "id_ficha_med")
    private FichaMed idFichaMed;

    @ManyToOne
    @JoinColumn(name = "id_contato_emergencia")
    private ContatoEmergencia idContato;

    @ManyToOne
    @JoinColumn(name = "id_momento")
    private Momento idMomento;

    @ManyToMany
    @JoinTable(
            name = "responsavel_discente",
            joinColumns = @JoinColumn(name = "id_disc"),
            inverseJoinColumns = @JoinColumn(name = "id_resp")
    )
    List<Responsavel> responsaveis;
}
