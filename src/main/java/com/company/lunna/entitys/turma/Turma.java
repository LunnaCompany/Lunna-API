package com.company.lunna.entitys.turma;

import com.company.lunna.entitys.discente.Discente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TURMA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTurma;

    @Column(nullable = false)
    private String nomeTurma;

    @Column(nullable = false)
    private int quantidadeAlunos;

    @Column(nullable = false)
    private String periodo;

    @Column(nullable = false)
    private String tema;

    @OneToMany(mappedBy = "turma")
    @JsonManagedReference
    private List<Discente> discentes;
}