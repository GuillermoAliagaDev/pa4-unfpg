package pe.edu.isil.plaza_compras_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/ordenes-compra")
public class OrdenCompraController {
    private final OrdenCompraRepository repo;

    public OrdenCompraController(OrdenCompraRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<OrdenCompra> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public OrdenCompra buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdenCompra crear(@RequestBody OrdenCompra body) {
        body.codordc = null;
        body.estordc = true;
        return repo.save(body);
    }

    @PutMapping("/{id}")
    public OrdenCompra actualizar(@PathVariable Integer id, @RequestBody OrdenCompra body) {
        var actual = buscar(id);
        
actual.numordc = body.numordc;        actual.fecordc = body.fecordc;        actual.codprv = body.codprv;        actual.totordc = body.totordc;        actual.obsordc = body.obsordc;
        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public OrdenCompra baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public OrdenCompra alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private OrdenCompra estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estordc = activo;
        return repo.save(actual);
    }

}
