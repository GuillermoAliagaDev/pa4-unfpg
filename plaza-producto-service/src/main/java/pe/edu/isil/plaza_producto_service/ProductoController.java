package pe.edu.isil.plaza_producto_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoRepository repo;

    public ProductoController(ProductoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Producto> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto body) {
        body.codpro = null;
        body.estpro = true;
        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Integer id, @RequestBody Producto body) {
        var actual = buscar(id);
        
actual.nompro = body.nompro;        actual.despro = body.despro;        actual.prepro = body.prepro;        actual.stopro = body.stopro;        actual.codcat = body.codcat;        actual.codprv = body.codprv;
        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Producto baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Producto alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Producto estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estpro = activo;
        return repo.save(actual);
    }

}
