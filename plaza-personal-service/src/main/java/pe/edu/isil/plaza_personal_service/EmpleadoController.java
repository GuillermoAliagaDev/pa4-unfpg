package pe.edu.isil.plaza_personal_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    private final EmpleadoRepository repo;

    public EmpleadoController(EmpleadoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Empleado> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Empleado buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado crear(@RequestBody Empleado body) {
        body.codemp = null;
        body.estemp = true;
        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Empleado actualizar(@PathVariable Integer id, @RequestBody Empleado body) {
        var actual = buscar(id);
        
actual.numdoc = body.numdoc;        actual.nomemp = body.nomemp;        actual.apeemp = body.apeemp;        actual.caremp = body.caremp;        actual.codsuc = body.codsuc;
        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Empleado baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Empleado alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Empleado estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estemp = activo;
        return repo.save(actual);
    }

}
