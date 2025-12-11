package com.example.demo.repository;

import com.example.demo.model.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
    Optional<Etiqueta> findByNombre(String nombre);
}