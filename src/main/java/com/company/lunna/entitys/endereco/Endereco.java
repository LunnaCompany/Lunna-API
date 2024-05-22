package com.company.lunna.entitys.endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Endereco {
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String uf;
}
