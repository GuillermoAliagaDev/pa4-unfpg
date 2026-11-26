package pe.edu.isil.unfpg_academico_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/matriculas") public class MatriculaController {
 private final MatriculaRepository repo;
 public MatriculaController(MatriculaRepository repo) {this.repo=repo;}
 @GetMapping public List<Matricula> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Matricula buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Matricula crear(@RequestBody Matricula body) {body.nummat=null; body.estmat=true; return repo.save(body);}
 @PutMapping("/{id}") public Matricula actualizar(@PathVariable Integer id,@RequestBody Matricula body) {var actual=buscar(id); actual.obsmat=body.obsmat;actual.codalu=body.codalu;actual.codestm=body.codestm;actual.codtipm=body.codtipm;actual.codper=body.codper; return repo.save(actual);}
 @DeleteMapping("/{id}") public Matricula baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Matricula alta(@PathVariable Integer id) { return estado(id,true); }
private Matricula estado(Integer id, boolean activo) { var actual=buscar(id); actual.estmat=activo; return repo.save(actual); }
}