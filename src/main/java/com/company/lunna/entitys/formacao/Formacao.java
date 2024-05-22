package com.company.lunna.entitys.formacao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "FORMACAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Formacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFormcao;

    @Column(nullable = false)
    private String nomeForm;

    @Column(nullable = false)
    private Date dataIniForm;
}
