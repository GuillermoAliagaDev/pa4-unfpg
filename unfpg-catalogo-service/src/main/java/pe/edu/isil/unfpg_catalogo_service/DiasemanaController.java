package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/diasemana") public class DiasemanaController {
 private final DiasemanaRepository repo;
 public DiasemanaController(DiasemanaRepository repo) {this.repo=repo;}
 @GetMapping public List<Diasemana> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Diasemana buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Diasemana crear(@RequestBody Diasemana body) {body.coddias=null; body.estdias=true; return repo.save(body);}
 @PutMapping("/{id}") public Diasemana actualizar(@PathVariable Integer id,@RequestBody Diasemana body) {var actual=buscar(id); actual.nomdias=body.nomdias; return repo.save(actual);}
 @DeleteMapping("/{id}") public Diasemana baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Diasemana alta(@PathVariable Integer id) { return estado(id,true); }
private Diasemana estado(Integer id, boolean activo) { var actual=buscar(id); actual.estdias=activo; return repo.save(actual); }
}