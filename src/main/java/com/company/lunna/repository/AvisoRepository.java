package com.company.lunna.repository;

import com.company.lunna.entitys.aviso.Aviso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisoRepository extends JpaRepository<Aviso, Integer> {
}
