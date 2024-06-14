package com.company.lunna.entitys.aviso;

import com.company.lunna.entitys.pedagogo.Pedagogo;
import jakarta.persistence.*;

@Entity
@Table(name = "AVISO")
public class Aviso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAviso;

    @Column(nullable = false)
    private String tituloAviso;

    @Column(nullable = false)
    private String conteudoAviso;

    @Column(nullable = false)
    private String importancia;

    @ManyToOne
    @JoinColumn(name = "id_pedagogo")
    private Pedagogo pedagogo;
    
}
