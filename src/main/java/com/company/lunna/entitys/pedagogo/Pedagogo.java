package com.company.lunna.entitys.pedagogo;

import com.company.lunna.entitys.formacao.Formacao;
import com.company.lunna.entitys.turma.Turma;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PEDAGOGO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedagogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedagogo;

    @Column(nullable = false)
    private String cpfPed;

    @Column(nullable = false)
    private String emailPed;

    @Column(nullable = false)
    private String senhaPed;

    @Column(nullable = false)
    private String numeroTelPed;

    @ManyToOne
    @JoinColumn(name = "id_formacao")
    private Formacao idFormacao;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma idTurma;
}
