package pe.edu.isil.plaza_producto_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaRepository repo;

    public CategoriaController(CategoriaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Categoria> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Categoria buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria crear(@RequestBody Categoria body) {
        body.codcat = null;
        body.estcat = true;
        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable Integer id, @RequestBody Categoria body) {
        var actual = buscar(id);
        
actual.nomcat = body.nomcat;        actual.descat = body.descat;
        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Categoria baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Categoria alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Categoria estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estcat = activo;
        return repo.save(actual);
    }

}
