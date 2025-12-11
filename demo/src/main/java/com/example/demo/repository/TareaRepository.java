package com.example.demo.repository;

import com.example.demo.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

    @Query(value = "SELECT * FROM tarea WHERE id IN :ids", nativeQuery = true)
    List<Tarea> findByIdIn(@Param("ids") List<Long> ids);

    @Query(value = "SELECT * FROM tarea t WHERE t.estimacion_horas = :estimacionHoras AND t.horas_invertidas = :horasInvertidas", nativeQuery = true)
    List<Tarea> findByEstimacionYHorasInvertidas(
            @Param("estimacionHoras") Integer estimacionHoras,
            @Param("horasInvertidas") Integer horasInvertidas
    );


    @Query(value = "SELECT * FROM tarea t WHERE t.estimacion_horas >= :minEstimacion AND t.estimacion_horas <= :maxEstimacion AND t.horas_invertidas >= :minHoras AND t.horas_invertidas <= :maxHoras", nativeQuery = true)
    List<Tarea> findByRangoEstimacionYHoras(
            @Param("minEstimacion") Integer minEstimacion,
            @Param("maxEstimacion") Integer maxEstimacion,
            @Param("minHoras") Integer minHoras,
            @Param("maxHoras") Integer maxHoras
    );
}