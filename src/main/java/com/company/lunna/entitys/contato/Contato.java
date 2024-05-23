package com.company.lunna.entitys.contato;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Contato {
    @Column(nullable = false)
    private String numeroTel;
    @Column(nullable = false)
    private String numeroCel;
}
