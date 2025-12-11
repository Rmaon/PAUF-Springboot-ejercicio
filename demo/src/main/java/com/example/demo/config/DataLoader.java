package com.example.demo.config;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final EstadoTareaRepository estadoTareaRepository;
    private final EstadoSprintRepository estadoSprintRepository;
    private final PrioridadTareaRepository prioridadTareaRepository;
    private final RolProgramadorRepository rolProgramadorRepository;
    private final ProgramadorRepository programadorRepository;
    private final SprintRepository sprintRepository;
    private final EtiquetaRepository etiquetaRepository;
    private final TareaRepository tareaRepository;

    public DataLoader(EstadoTareaRepository estadoTareaRepository,
                      EstadoSprintRepository estadoSprintRepository,
                      PrioridadTareaRepository prioridadTareaRepository,
                      RolProgramadorRepository rolProgramadorRepository,
                      ProgramadorRepository programadorRepository,
                      SprintRepository sprintRepository,
                      EtiquetaRepository etiquetaRepository,
                      TareaRepository tareaRepository) {
        this.estadoTareaRepository = estadoTareaRepository;
        this.estadoSprintRepository = estadoSprintRepository;
        this.prioridadTareaRepository = prioridadTareaRepository;
        this.rolProgramadorRepository = rolProgramadorRepository;
        this.programadorRepository = programadorRepository;
        this.sprintRepository = sprintRepository;
        this.etiquetaRepository = etiquetaRepository;
        this.tareaRepository = tareaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Solo cargar datos si la BD está vacía
        if (estadoTareaRepository.count() > 0) {
            System.out.println("=== DATOS YA EXISTENTES - SALTANDO CARGA ===");
            return;
        }

        // Estados de Tarea
        EstadoTarea todo = new EstadoTarea(null, "TODO");
        EstadoTarea doing = new EstadoTarea(null, "DOING");
        EstadoTarea review = new EstadoTarea(null, "REVIEW");
        EstadoTarea done = new EstadoTarea(null, "DONE");
        estadoTareaRepository.saveAll(Arrays.asList(todo, doing, review, done));

        // Estados de Sprint
        EstadoSprint planned = new EstadoSprint(null, "PLANNED");
        EstadoSprint active = new EstadoSprint(null, "ACTIVE");
        EstadoSprint closed = new EstadoSprint(null, "CLOSED");
        estadoSprintRepository.saveAll(Arrays.asList(planned, active, closed));

        // Prioridades
        PrioridadTarea low = new PrioridadTarea(null, "LOW");
        PrioridadTarea medium = new PrioridadTarea(null, "MEDIUM");
        PrioridadTarea high = new PrioridadTarea(null, "HIGH");
        PrioridadTarea critical = new PrioridadTarea(null, "CRITICAL");
        prioridadTareaRepository.saveAll(Arrays.asList(low, medium, high, critical));

        // Roles de Programador
        RolProgramador dev = new RolProgramador(null, "DEV");
        RolProgramador test = new RolProgramador(null, "TEST");
        RolProgramador lead = new RolProgramador(null, "LEAD");
        rolProgramadorRepository.saveAll(Arrays.asList(dev, test, lead));

        // ACTIVIDAD 2: 5 Programadores reales
        Programador prog1 = new Programador(null, "María García López", "maria.garcia@techcorp.es", dev, 40);
        Programador prog2 = new Programador(null, "Carlos Rodríguez Martín", "carlos.rodriguez@techcorp.es", dev, 40);
        Programador prog3 = new Programador(null, "Ana Fernández Ruiz", "ana.fernandez@techcorp.es", test, 35);
        Programador prog4 = new Programador(null, "Javier Sánchez Gómez", "javier.sanchez@techcorp.es", lead, 30);
        Programador prog5 = new Programador(null, "Laura Martínez Díaz", "laura.martinez@techcorp.es", dev, 40);
        programadorRepository.saveAll(Arrays.asList(prog1, prog2, prog3, prog4, prog5));

        // ACTIVIDAD 2: 2 Sprints reales
        Sprint sprint1 = new Sprint(null, "Sprint 1 - MVP Autenticación",
                LocalDate.of(2025, 1, 6), LocalDate.of(2025, 1, 20),
                "Implementar sistema de autenticación y autorización de usuarios",
                active);
        Sprint sprint2 = new Sprint(null, "Sprint 2 - Gestión de Productos",
                LocalDate.of(2025, 1, 21), LocalDate.of(2025, 2, 4),
                "Desarrollar CRUD completo de productos con categorías",
                planned);
        sprintRepository.saveAll(Arrays.asList(sprint1, sprint2));

        // ACTIVIDAD 2: 10 Etiquetas reales
        Etiqueta etqBackend = new Etiqueta(null, "Backend", "#3498DB");
        Etiqueta etqFrontend = new Etiqueta(null, "Frontend", "#E74C3C");
        Etiqueta etqDatabase = new Etiqueta(null, "Database", "#27AE60");
        Etiqueta etqSecurity = new Etiqueta(null, "Security", "#8E44AD");
        Etiqueta etqAPI = new Etiqueta(null, "API", "#F39C12");
        Etiqueta etqBugfix = new Etiqueta(null, "Bugfix", "#E91E63");
        Etiqueta etqRefactor = new Etiqueta(null, "Refactor", "#00BCD4");
        Etiqueta etqUI = new Etiqueta(null, "UI/UX", "#9C27B0");
        Etiqueta etqTesting = new Etiqueta(null, "Testing", "#4CAF50");
        Etiqueta etqDocumentation = new Etiqueta(null, "Documentation", "#607D8B");
        etiquetaRepository.saveAll(Arrays.asList(etqBackend, etqFrontend, etqDatabase, etqSecurity,
                etqAPI, etqBugfix, etqRefactor, etqUI, etqTesting, etqDocumentation));

        // ACTIVIDAD 2: 10 Tareas reales
        Tarea tarea1 = new Tarea();
        tarea1.setTitulo("Implementar JWT Authentication");
        tarea1.setDescripcion("Configurar Spring Security con JWT para autenticación stateless");
        tarea1.setStoryPoint(8);
        tarea1.setPrioridad(critical);
        tarea1.setEstado(doing);
        tarea1.setEstimacionHoras(16);
        tarea1.setHorasInvertidas(10);
        tarea1.setSprint(sprint1);
        tarea1.getEtiquetas().add(etqBackend);
        tarea1.getEtiquetas().add(etqSecurity);

        Tarea tarea2 = new Tarea();
        tarea2.setTitulo("Crear formulario de login");
        tarea2.setDescripcion("Diseñar e implementar formulario de login con validaciones");
        tarea2.setStoryPoint(5);
        tarea2.setPrioridad(high);
        tarea2.setEstado(done);
        tarea2.setEstimacionHoras(8);
        tarea2.setHorasInvertidas(8);
        tarea2.setSprint(sprint1);
        tarea2.getEtiquetas().add(etqFrontend);
        tarea2.getEtiquetas().add(etqUI);

        Tarea tarea3 = new Tarea();
        tarea3.setTitulo("Diseñar modelo de datos de usuarios");
        tarea3.setDescripcion("Crear entidades User, Role y sus relaciones en JPA");
        tarea3.setStoryPoint(3);
        tarea3.setPrioridad(high);
        tarea3.setEstado(done);
        tarea3.setEstimacionHoras(6);
        tarea3.setHorasInvertidas(5);
        tarea3.setSprint(sprint1);
        tarea3.getEtiquetas().add(etqDatabase);
        tarea3.getEtiquetas().add(etqBackend);

        Tarea tarea4 = new Tarea();
        tarea4.setTitulo("Endpoint REST para registro");
        tarea4.setDescripcion("Implementar POST /api/auth/register con validaciones");
        tarea4.setStoryPoint(5);
        tarea4.setPrioridad(high);
        tarea4.setEstado(review);
        tarea4.setEstimacionHoras(8);
        tarea4.setHorasInvertidas(7);
        tarea4.setSprint(sprint1);
        tarea4.getEtiquetas().add(etqAPI);
        tarea4.getEtiquetas().add(etqBackend);

        Tarea tarea5 = new Tarea();
        tarea5.setTitulo("Tests unitarios autenticación");
        tarea5.setDescripcion("Crear tests para AuthService y AuthController");
        tarea5.setStoryPoint(5);
        tarea5.setPrioridad(medium);
        tarea5.setEstado(todo);
        tarea5.setEstimacionHoras(10);
        tarea5.setHorasInvertidas(0);
        tarea5.setSprint(sprint1);
        tarea5.getEtiquetas().add(etqTesting);

        Tarea tarea6 = new Tarea();
        tarea6.setTitulo("CRUD Productos - Backend");
        tarea6.setDescripcion("Implementar servicio y controlador para gestión de productos");
        tarea6.setStoryPoint(8);
        tarea6.setPrioridad(high);
        tarea6.setEstado(todo);
        tarea6.setEstimacionHoras(16);
        tarea6.setHorasInvertidas(0);
        tarea6.setSprint(sprint2);
        tarea6.getEtiquetas().add(etqBackend);
        tarea6.getEtiquetas().add(etqAPI);

        Tarea tarea7 = new Tarea();
        tarea7.setTitulo("Modelo de categorías");
        tarea7.setDescripcion("Crear entidad Category con relación jerárquica");
        tarea7.setStoryPoint(3);
        tarea7.setPrioridad(medium);
        tarea7.setEstado(todo);
        tarea7.setEstimacionHoras(6);
        tarea7.setHorasInvertidas(0);
        tarea7.setSprint(sprint2);
        tarea7.getEtiquetas().add(etqDatabase);

        Tarea tarea8 = new Tarea();
        tarea8.setTitulo("Fix bug en validación email");
        tarea8.setDescripcion("Corregir regex de validación que no acepta dominios .es");
        tarea8.setStoryPoint(1);
        tarea8.setPrioridad(critical);
        tarea8.setEstado(done);
        tarea8.setEstimacionHoras(2);
        tarea8.setHorasInvertidas(2);
        tarea8.setSprint(sprint1);
        tarea8.getEtiquetas().add(etqBugfix);
        tarea8.getEtiquetas().add(etqBackend);

        Tarea tarea9 = new Tarea();
        tarea9.setTitulo("Refactorizar AuthService");
        tarea9.setDescripcion("Extraer lógica de tokens a clase TokenService separada");
        tarea9.setStoryPoint(3);
        tarea9.setPrioridad(low);
        tarea9.setEstado(todo);
        tarea9.setEstimacionHoras(6);
        tarea9.setHorasInvertidas(0);
        tarea9.setSprint(sprint1);
        tarea9.getEtiquetas().add(etqRefactor);

        Tarea tarea10 = new Tarea();
        tarea10.setTitulo("Documentar API endpoints");
        tarea10.setDescripcion("Configurar Swagger/OpenAPI para documentación automática");
        tarea10.setStoryPoint(3);
        tarea10.setPrioridad(medium);
        tarea10.setEstado(todo);
        tarea10.setEstimacionHoras(6);
        tarea10.setHorasInvertidas(0);
        tarea10.setSprint(sprint2);
        tarea10.getEtiquetas().add(etqDocumentation);
        tarea10.getEtiquetas().add(etqAPI);

        tareaRepository.saveAll(Arrays.asList(tarea1, tarea2, tarea3, tarea4, tarea5,
                tarea6, tarea7, tarea8, tarea9, tarea10));

        System.out.println("=== DATOS DE PRUEBA CARGADOS ===");
        System.out.println("- 5 Programadores");
        System.out.println("- 2 Sprints");
        System.out.println("- 10 Etiquetas");
        System.out.println("- 10 Tareas con relaciones ManyToMany");
    }
}