package pe.edu.isil.plaza_ventas_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    private final VentaRepository repo;

    public VentaController(VentaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Venta> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Venta buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venta crear(@RequestBody Venta body) {
        body.codven = null;
        body.estven = true;
        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Venta actualizar(@PathVariable Integer id, @RequestBody Venta body) {
        var actual = buscar(id);
        
actual.numcom = body.numcom;        actual.fecven = body.fecven;        actual.codcli = body.codcli;        actual.codemp = body.codemp;        actual.codmetp = body.codmetp;        actual.totven = body.totven;
        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Venta baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Venta alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Venta estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estven = activo;
        return repo.save(actual);
    }

}
