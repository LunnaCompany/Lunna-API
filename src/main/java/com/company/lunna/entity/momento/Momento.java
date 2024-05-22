package com.company.lunna.entity.momento;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MOMENTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Momento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMomento;

    @Column(nullable = false)
    private String tituloMmt;

    @Column(nullable = false)
    private String imgMmt;

    @Column(nullable = false)
    private Boolean isFav;
}
