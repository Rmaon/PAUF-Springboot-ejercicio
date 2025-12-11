package com.example.demo.repository;

import com.example.demo.model.PrioridadTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrioridadTareaRepository extends JpaRepository<PrioridadTarea, Long> {
}