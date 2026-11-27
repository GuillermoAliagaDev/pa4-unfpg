package pe.edu.isil.plaza_logistica_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/almacenes")
public class AlmacenController {
    private final AlmacenRepository repo;

    public AlmacenController(AlmacenRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Almacen> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Almacen buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Almacen crear(@RequestBody Almacen body) {
        body.codalm = null;
        body.estalm = true;
        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Almacen actualizar(@PathVariable Integer id, @RequestBody Almacen body) {
        var actual = buscar(id);
        
actual.nomalm = body.nomalm;        actual.ubialm = body.ubialm;        actual.codsuc = body.codsuc;
        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Almacen baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Almacen alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Almacen estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estalm = activo;
        return repo.save(actual);
    }

}
