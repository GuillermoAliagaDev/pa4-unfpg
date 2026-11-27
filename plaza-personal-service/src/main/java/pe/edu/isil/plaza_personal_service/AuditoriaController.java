package pe.edu.isil.plaza_personal_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/auditorias")
public class AuditoriaController {
    private final AuditoriaRepository repo;

    public AuditoriaController(AuditoriaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Auditoria> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Auditoria buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Auditoria crear(@RequestBody Auditoria body) {
        body.codaud = null;
        body.estaud = true;
        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Auditoria actualizar(@PathVariable Integer id, @RequestBody Auditoria body) {
        var actual = buscar(id);
        
actual.codusu = body.codusu;        actual.accaud = body.accaud;        actual.fecaud = body.fecaud;
        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Auditoria baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Auditoria alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Auditoria estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estaud = activo;
        return repo.save(actual);
    }

}
