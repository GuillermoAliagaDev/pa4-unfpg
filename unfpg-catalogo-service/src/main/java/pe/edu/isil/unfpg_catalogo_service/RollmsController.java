package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/rollms") public class RollmsController {
 private final RollmsRepository repo;
 public RollmsController(RollmsRepository repo) {this.repo=repo;}
 @GetMapping public List<Rollms> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Rollms buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Rollms crear(@RequestBody Rollms body) {body.codroll=null; body.estroll=true; return repo.save(body);}
 @PutMapping("/{id}") public Rollms actualizar(@PathVariable Integer id,@RequestBody Rollms body) {var actual=buscar(id); actual.nomroll=body.nomroll; return repo.save(actual);}
 @DeleteMapping("/{id}") public Rollms baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Rollms alta(@PathVariable Integer id) { return estado(id,true); }
private Rollms estado(Integer id, boolean activo) { var actual=buscar(id); actual.estroll=activo; return repo.save(actual); }
}