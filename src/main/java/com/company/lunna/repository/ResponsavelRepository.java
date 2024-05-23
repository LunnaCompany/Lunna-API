package com.company.lunna.repository;

import com.company.lunna.entitys.responsavel.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer> {
    Optional<Responsavel> findByEmailResp(String email);
    Optional<Responsavel> findByCpfResp(String cpf);
}
