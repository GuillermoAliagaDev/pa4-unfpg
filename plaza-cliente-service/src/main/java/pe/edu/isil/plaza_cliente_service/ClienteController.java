package pe.edu.isil.plaza_cliente_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteRepository repo;

    public ClienteController(ClienteRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Cliente> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente crear(@RequestBody Cliente body) {
        body.codcli = null;
        body.estcli = true;
        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Integer id, @RequestBody Cliente body) {
        var actual = buscar(id);
        
actual.nomcli = body.nomcli;        actual.apecli = body.apecli;        actual.numdoc = body.numdoc;        actual.codtipd = body.codtipd;        actual.telcli = body.telcli;        actual.corcli = body.corcli;        actual.dircli = body.dircli;
        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Cliente baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Cliente alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Cliente estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estcli = activo;
        return repo.save(actual);
    }

}
