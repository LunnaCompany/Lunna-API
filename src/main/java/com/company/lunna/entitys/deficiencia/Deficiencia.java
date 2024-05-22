package com.company.lunna.entitys.deficiencia;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DEFICIENCIA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deficiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDef;

    @Column(nullable = false)
    private String nomeDef;
}
