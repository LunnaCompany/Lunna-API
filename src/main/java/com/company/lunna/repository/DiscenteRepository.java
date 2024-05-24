package com.company.lunna.repository;

import com.company.lunna.entitys.discente.Discente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscenteRepository extends JpaRepository<Discente, Integer> {
    Optional<Discente> findByCpf(String cpf);
}
