package com.company.lunna.dtos.requests;

import com.company.lunna.entitys.fichaMed.FichaMed;

import java.time.LocalDate;
import java.util.List;

public record DiscenteRequestDTO(String cpfDisc, String nomeDisc, LocalDate dataNasDisc, Float alturaDisc, Float pesoDisc, String imgDisc, FichaMedRequestDTO fichaMed){}
