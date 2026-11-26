package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/estadomatricula") public class EstadomatriculaController {
 private final EstadomatriculaRepository repo;
 public EstadomatriculaController(EstadomatriculaRepository repo) {this.repo=repo;}
 @GetMapping public List<Estadomatricula> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Estadomatricula buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Estadomatricula crear(@RequestBody Estadomatricula body) {body.codestm=null; body.estestm=true; return repo.save(body);}
 @PutMapping("/{id}") public Estadomatricula actualizar(@PathVariable Integer id,@RequestBody Estadomatricula body) {var actual=buscar(id); actual.nomestm=body.nomestm; return repo.save(actual);}
 @DeleteMapping("/{id}") public Estadomatricula baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Estadomatricula alta(@PathVariable Integer id) { return estado(id,true); }
private Estadomatricula estado(Integer id, boolean activo) { var actual=buscar(id); actual.estestm=activo; return repo.save(actual); }
}