package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/conceptopago") public class ConceptopagoController {
 private final ConceptopagoRepository repo;
 public ConceptopagoController(ConceptopagoRepository repo) {this.repo=repo;}
 @GetMapping public List<Conceptopago> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Conceptopago buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Conceptopago crear(@RequestBody Conceptopago body) {body.codconp=null; body.estconp=true; return repo.save(body);}
 @PutMapping("/{id}") public Conceptopago actualizar(@PathVariable Integer id,@RequestBody Conceptopago body) {var actual=buscar(id); actual.nomconp=body.nomconp;actual.desconp=body.desconp; return repo.save(actual);}
 @DeleteMapping("/{id}") public Conceptopago baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Conceptopago alta(@PathVariable Integer id) { return estado(id,true); }
private Conceptopago estado(Integer id, boolean activo) { var actual=buscar(id); actual.estconp=activo; return repo.save(actual); }
}