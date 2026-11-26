package pe.edu.isil.unfpg_academico_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/aula") public class AulaController {
 private final AulaRepository repo;
 public AulaController(AulaRepository repo) {this.repo=repo;}
 @GetMapping public List<Aula> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Aula buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Aula crear(@RequestBody Aula body) {body.codaul=null;  return repo.save(body);}
 @PutMapping("/{id}") public Aula actualizar(@PathVariable Integer id,@RequestBody Aula body) {var actual=buscar(id); actual.nomaul=body.nomaul;actual.capaul=body.capaul;actual.codubi=body.codubi;actual.codtipa=body.codtipa;actual.codesta=body.codesta; return repo.save(actual);}
 
}