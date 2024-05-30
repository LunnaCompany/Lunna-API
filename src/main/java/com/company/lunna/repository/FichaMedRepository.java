package com.company.lunna.repository;

import com.company.lunna.entitys.fichaMed.FichaMed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaMedRepository extends JpaRepository<FichaMed, Integer> {
}
