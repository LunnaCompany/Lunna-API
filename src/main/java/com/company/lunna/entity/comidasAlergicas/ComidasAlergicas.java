package com.company.lunna.entity.comidasAlergicas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

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
