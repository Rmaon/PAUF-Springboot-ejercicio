package com.example.demo.controller;

import com.example.demo.model.Sprint;
import com.example.demo.model.Tarea;
import com.example.demo.repository.SprintRepository;
import com.example.demo.repository.TareaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultasController {

    private final TareaRepository tareaRepository;
    private final SprintRepository sprintRepository;

    public ConsultasController(TareaRepository tareaRepository, SprintRepository sprintRepository) {
        this.tareaRepository = tareaRepository;
        this.sprintRepository = sprintRepository;
    }


    @GetMapping("/tareas/horas")
    public ResponseEntity<List<Tarea>> buscarPorHoras(@RequestParam Integer estimacionHoras, @RequestParam Integer horasInvertidas) {
        List<Tarea> tareas = tareaRepository.findByEstimacionYHorasInvertidas(estimacionHoras, horasInvertidas);
        return ResponseEntity.ok(tareas);
    }


    @GetMapping("/tareas/horas/rango")
    public ResponseEntity<List<Tarea>> buscarPorRangoHoras(@RequestParam Integer minEstimacion, @RequestParam Integer maxEstimacion, @RequestParam Integer minHoras, @RequestParam Integer maxHoras) {
        List<Tarea> tareas = tareaRepository.findByRangoEstimacionYHoras(minEstimacion, maxEstimacion, minHoras, maxHoras);
        return ResponseEntity.ok(tareas);
    }


    @GetMapping("/sprints/objetivo")
    public ResponseEntity<List<Sprint>> buscarPorObjetivoYSprints(@RequestParam String objetivo, @RequestParam List<Long> sprintIds) {
        List<Sprint> sprints = sprintRepository.findByObjetivoAndSprintIds(objetivo, sprintIds);
        return ResponseEntity.ok(sprints);
    }


    @GetMapping("/sprints/buscar")
    public ResponseEntity<List<Sprint>> buscarPorObjetivo(@RequestParam String objetivo) {
        List<Sprint> sprints = sprintRepository.findByObjetivoContaining(objetivo);
        return ResponseEntity.ok(sprints);
    }

    @GetMapping("/tareas/ids")
    public ResponseEntity<List<Tarea>> buscarPorIds(@RequestParam List<Long> ids) {
        List<Tarea> tareas = tareaRepository.findByIdIn(ids);
        return ResponseEntity.ok(tareas);
    }
}