package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/estadoaula") public class EstadoaulaController {
 private final EstadoaulaRepository repo;
 public EstadoaulaController(EstadoaulaRepository repo) {this.repo=repo;}
 @GetMapping public List<Estadoaula> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Estadoaula buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Estadoaula crear(@RequestBody Estadoaula body) {body.codesta=null; body.estesta=true; return repo.save(body);}
 @PutMapping("/{id}") public Estadoaula actualizar(@PathVariable Integer id,@RequestBody Estadoaula body) {var actual=buscar(id); actual.nomesta=body.nomesta; return repo.save(actual);}
 @DeleteMapping("/{id}") public Estadoaula baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Estadoaula alta(@PathVariable Integer id) { return estado(id,true); }
private Estadoaula estado(Integer id, boolean activo) { var actual=buscar(id); actual.estesta=activo; return repo.save(actual); }
}