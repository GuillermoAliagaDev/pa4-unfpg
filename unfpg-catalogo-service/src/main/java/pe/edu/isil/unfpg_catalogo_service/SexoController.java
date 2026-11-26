package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/sexo") public class SexoController {
 private final SexoRepository repo;
 public SexoController(SexoRepository repo) {this.repo=repo;}
 @GetMapping public List<Sexo> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Sexo buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Sexo crear(@RequestBody Sexo body) {body.codsex=null; body.estsex=true; return repo.save(body);}
 @PutMapping("/{id}") public Sexo actualizar(@PathVariable Integer id,@RequestBody Sexo body) {var actual=buscar(id); actual.nomsex=body.nomsex; return repo.save(actual);}
 @DeleteMapping("/{id}") public Sexo baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Sexo alta(@PathVariable Integer id) { return estado(id,true); }
private Sexo estado(Integer id, boolean activo) { var actual=buscar(id); actual.estsex=activo; return repo.save(actual); }
}