package com.company.lunna.entitys.enderecoHospital;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;

@Embeddable
@Data
public class EnderecoHospital {
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String uf;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String nomeHospital;
}
