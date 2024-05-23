package com.company.lunna.dtos;

import java.time.LocalDate;

public record DiscenteRequestDTO(String cpfDisc, String nome_disc, LocalDate dataNasDisc, Float alturaDisc, Float pesoDisc, String imgDisc){}
