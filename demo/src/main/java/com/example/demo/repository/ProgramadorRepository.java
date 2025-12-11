package com.example.demo.repository;

import com.example.demo.model.Programador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramadorRepository extends JpaRepository<Programador, Long> {
}