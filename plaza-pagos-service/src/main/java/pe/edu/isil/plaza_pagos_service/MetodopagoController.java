package pe.edu.isil.plaza_pagos_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/metodospago")
public class MetodopagoController {
    private final MetodopagoRepository repo;

    public MetodopagoController(MetodopagoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Metodopago> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Metodopago buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Metodopago crear(@RequestBody Metodopago body) {
        body.codmetp = null;
        body.estmetp = true;
        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Metodopago actualizar(@PathVariable Integer id, @RequestBody Metodopago body) {
        var actual = buscar(id);
        
actual.nommetp = body.nommetp;
        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Metodopago baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Metodopago alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Metodopago estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estmetp = activo;
        return repo.save(actual);
    }

}
