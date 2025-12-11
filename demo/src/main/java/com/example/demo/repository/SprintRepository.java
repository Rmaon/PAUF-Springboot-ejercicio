package com.example.demo.repository;

import com.example.demo.model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {


    @Query(value = "SELECT * FROM sprint s WHERE s.objetivo LIKE %:objetivo% AND s.id IN :sprintIds", nativeQuery = true)
    List<Sprint> findByObjetivoAndSprintIds(
            @Param("objetivo") String objetivo,
            @Param("sprintIds") List<Long> sprintIds
    );


    @Query(value = "SELECT * FROM sprint s WHERE s.objetivo LIKE %:objetivo%", nativeQuery = true)
    List<Sprint> findByObjetivoContaining(@Param("objetivo") String objetivo);
}