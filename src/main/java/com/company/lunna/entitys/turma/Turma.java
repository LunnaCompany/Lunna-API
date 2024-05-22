package com.company.lunna.entitys.turma;

import com.company.lunna.entitys.discente.Discente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    @JoinColumn(name = "id_disc")
    private Discente discenteId;
}
