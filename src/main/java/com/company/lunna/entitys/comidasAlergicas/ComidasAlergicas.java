package com.company.lunna.entitys.comidasAlergicas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COMIDAS_ALERGICAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComidasAlergicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComidasAlergicas;
    private String nomeComida;

}
