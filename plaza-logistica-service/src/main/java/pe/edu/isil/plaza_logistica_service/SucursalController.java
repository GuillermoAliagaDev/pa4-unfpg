package pe.edu.isil.plaza_logistica_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {
    private final SucursalRepository repo;

    public SucursalController(SucursalRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Sucursal> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Sucursal buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sucursal crear(@RequestBody Sucursal body) {
        body.codsuc = null;
        body.estsuc = true;
        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Sucursal actualizar(@PathVariable Integer id, @RequestBody Sucursal body) {
        var actual = buscar(id);
        
actual.nomsuc = body.nomsuc;        actual.dirsuc = body.dirsuc;        actual.telsuc = body.telsuc;
        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Sucursal baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Sucursal alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Sucursal estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estsuc = activo;
        return repo.save(actual);
    }

}
