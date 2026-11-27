package pe.edu.isil.plaza_logistica_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/inventarios")
public class InventarioController {
    private final InventarioRepository repo;

    public InventarioController(InventarioRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Inventario> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Inventario buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Inventario crear(@RequestBody Inventario body) {
        body.codinv = null;
        body.estinv = true;
        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Inventario actualizar(@PathVariable Integer id, @RequestBody Inventario body) {
        var actual = buscar(id);
        
actual.codpro = body.codpro;        actual.codalm = body.codalm;        actual.caninv = body.caninv;
        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Inventario baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Inventario alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Inventario estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estinv = activo;
        return repo.save(actual);
    }

}
