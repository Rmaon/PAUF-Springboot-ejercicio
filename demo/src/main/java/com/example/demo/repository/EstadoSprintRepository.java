package com.example.demo.repository;

import com.example.demo.model.EstadoSprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoSprintRepository extends JpaRepository<EstadoSprint, Long> {
}