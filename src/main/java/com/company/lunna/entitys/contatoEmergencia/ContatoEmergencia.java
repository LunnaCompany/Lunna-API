package com.company.lunna.entitys.contatoEmergencia;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CONTATO_EMERGENCIA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoEmergencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContato;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String numeroTelefone;
    @Column(nullable = false)
    private String numeroCelular;
    @Column(nullable = false)
    private String parentesco;
}
