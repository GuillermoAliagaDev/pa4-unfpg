package pe.edu.isil.plaza_compras_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    private final ProveedorRepository repo;

    public ProveedorController(ProveedorRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Proveedor> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Proveedor buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proveedor crear(@RequestBody Proveedor body) {
        body.codprv = null;
        body.estprv = true;
        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Proveedor actualizar(@PathVariable Integer id, @RequestBody Proveedor body) {
        var actual = buscar(id);
        
actual.razprv = body.razprv;        actual.rucprv = body.rucprv;        actual.telprv = body.telprv;        actual.corprv = body.corprv;        actual.dirprv = body.dirprv;
        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Proveedor baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Proveedor alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Proveedor estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estprv = activo;
        return repo.save(actual);
    }

}
