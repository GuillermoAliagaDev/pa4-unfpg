package pe.edu.isil.plaza_logistica_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/despachos")
public class DespachoController {
    private final DespachoRepository repo;

    public DespachoController(DespachoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Despacho> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Despacho buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Despacho crear(@RequestBody Despacho body) {
        body.coddes = null;
        body.estdes = true;
        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Despacho actualizar(@PathVariable Integer id, @RequestBody Despacho body) {
        var actual = buscar(id);
        
actual.codped = body.codped;        actual.vehdes = body.vehdes;        actual.fecdes = body.fecdes;        actual.dirent = body.dirent;
        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Despacho baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Despacho alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Despacho estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estdes = activo;
        return repo.save(actual);
    }

}
