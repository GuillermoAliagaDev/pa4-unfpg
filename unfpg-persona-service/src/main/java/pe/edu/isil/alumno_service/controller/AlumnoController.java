package pe.edu.isil.alumno_service.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.isil.alumno_service.model.AlumnoRequestDTO;
import pe.edu.isil.alumno_service.model.AlumnoResponseDTO;
import pe.edu.isil.alumno_service.service.AlumnoService;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    // GET - Listar todos
    @GetMapping
    public ResponseEntity<List<AlumnoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(alumnoService.listarTodos());
    }

    // GET - Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponseDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(alumnoService.buscarPorId(id));
    }

    // POST - Registrar
    @PostMapping
    public ResponseEntity<AlumnoResponseDTO> crear(@Valid @RequestBody AlumnoRequestDTO dto) {
        AlumnoResponseDTO creado = alumnoService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // PUT - Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponseDTO> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody AlumnoRequestDTO dto) {
        return ResponseEntity.ok(alumnoService.actualizar(id, dto));
    }

    // DELETE - Deshabilitar (baja logica)
    @DeleteMapping("/{id}")
    public ResponseEntity<AlumnoResponseDTO> deshabilitar(@PathVariable Integer id) {
        return ResponseEntity.ok(alumnoService.deshabilitar(id));
    }

    // PATCH - Habilitar
    @PatchMapping("/{id}/habilitar")
    public ResponseEntity<AlumnoResponseDTO> habilitar(@PathVariable Integer id) {
        return ResponseEntity.ok(alumnoService.habilitar(id));
    }
}