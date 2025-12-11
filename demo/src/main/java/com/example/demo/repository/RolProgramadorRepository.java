package com.example.demo.repository;

import com.example.demo.model.RolProgramador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolProgramadorRepository extends JpaRepository<RolProgramador, Long> {
}