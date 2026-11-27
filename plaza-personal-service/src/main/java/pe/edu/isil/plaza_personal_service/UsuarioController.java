package pe.edu.isil.plaza_personal_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioRepository repo;

    public UsuarioController(UsuarioRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Usuario> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario crear(@RequestBody Usuario body) {
        body.codusu = null;
        body.estusu = true;
        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Integer id, @RequestBody Usuario body) {
        var actual = buscar(id);
        
actual.nomusu = body.nomusu;        actual.clausu = body.clausu;        actual.codemp = body.codemp;        actual.rolusu = body.rolusu;
        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Usuario baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Usuario alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Usuario estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estusu = activo;
        return repo.save(actual);
    }

}
