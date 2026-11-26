package pe.edu.isil.unfpg_aula_virtual_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/evaluaciones") public class EvaluacionlmsController {
 private final EvaluacionlmsRepository repo;
 public EvaluacionlmsController(EvaluacionlmsRepository repo) {this.repo=repo;}
 @GetMapping public List<Evaluacionlms> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Evaluacionlms buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Evaluacionlms crear(@RequestBody Evaluacionlms body) {body.codeval=null; body.esteval=true; return repo.save(body);}
 @PutMapping("/{id}") public Evaluacionlms actualizar(@PathVariable Integer id,@RequestBody Evaluacionlms body) {var actual=buscar(id); actual.nomeval=body.nomeval;actual.deseval=body.deseval;actual.feceval=body.feceval;actual.codcurl=body.codcurl; return repo.save(actual);}
 @DeleteMapping("/{id}") public Evaluacionlms baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Evaluacionlms alta(@PathVariable Integer id) { return estado(id,true); }
private Evaluacionlms estado(Integer id, boolean activo) { var actual=buscar(id); actual.esteval=activo; return repo.save(actual); }
}