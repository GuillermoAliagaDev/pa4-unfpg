package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/tipomatricula") public class TipomatriculaController {
 private final TipomatriculaRepository repo;
 public TipomatriculaController(TipomatriculaRepository repo) {this.repo=repo;}
 @GetMapping public List<Tipomatricula> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Tipomatricula buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Tipomatricula crear(@RequestBody Tipomatricula body) {body.codtipm=null; body.esttipm=true; return repo.save(body);}
 @PutMapping("/{id}") public Tipomatricula actualizar(@PathVariable Integer id,@RequestBody Tipomatricula body) {var actual=buscar(id); actual.nomtipm=body.nomtipm;actual.destipm=body.destipm; return repo.save(actual);}
 @DeleteMapping("/{id}") public Tipomatricula baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Tipomatricula alta(@PathVariable Integer id) { return estado(id,true); }
private Tipomatricula estado(Integer id, boolean activo) { var actual=buscar(id); actual.esttipm=activo; return repo.save(actual); }
}