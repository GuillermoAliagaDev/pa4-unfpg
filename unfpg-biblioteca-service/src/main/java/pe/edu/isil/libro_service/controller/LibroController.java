package pe.edu.isil.libro_service.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.isil.libro_service.model.LibroRequestDTO;
import pe.edu.isil.libro_service.model.LibroResponseDTO;
import pe.edu.isil.libro_service.service.LibroService;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // GET - Listar todos
    @GetMapping
    public ResponseEntity<List<LibroResponseDTO>> listarTodos() {
        return ResponseEntity.ok(libroService.listarTodos());
    }

    // GET - Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<LibroResponseDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(libroService.buscarPorId(id));
    }

    // POST - Registrar
    @PostMapping
    public ResponseEntity<LibroResponseDTO> crear(@Valid @RequestBody LibroRequestDTO dto) {
        LibroResponseDTO creado = libroService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // PUT - Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<LibroResponseDTO> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody LibroRequestDTO dto) {
        return ResponseEntity.ok(libroService.actualizar(id, dto));
    }

    // DELETE - Deshabilitar (baja logica)
    @DeleteMapping("/{id}")
    public ResponseEntity<LibroResponseDTO> deshabilitar(@PathVariable Integer id) {
        return ResponseEntity.ok(libroService.deshabilitar(id));
    }

    // PATCH - Habilitar
    @PatchMapping("/{id}/habilitar")
    public ResponseEntity<LibroResponseDTO> habilitar(@PathVariable Integer id) {
        return ResponseEntity.ok(libroService.habilitar(id));
    }
}