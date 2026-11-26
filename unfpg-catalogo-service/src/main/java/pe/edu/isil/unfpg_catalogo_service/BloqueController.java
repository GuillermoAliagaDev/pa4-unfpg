package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/bloque") public class BloqueController {
 private final BloqueRepository repo;
 public BloqueController(BloqueRepository repo) {this.repo=repo;}
 @GetMapping public List<Bloque> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Bloque buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Bloque crear(@RequestBody Bloque body) {body.codblo=null; body.estblo=true; return repo.save(body);}
 @PutMapping("/{id}") public Bloque actualizar(@PathVariable Integer id,@RequestBody Bloque body) {var actual=buscar(id); actual.nomblo=body.nomblo;actual.iniblo=body.iniblo;actual.finblo=body.finblo; return repo.save(actual);}
 @DeleteMapping("/{id}") public Bloque baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Bloque alta(@PathVariable Integer id) { return estado(id,true); }
private Bloque estado(Integer id, boolean activo) { var actual=buscar(id); actual.estblo=activo; return repo.save(actual); }
}