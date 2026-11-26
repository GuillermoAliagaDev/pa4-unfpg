package pe.edu.isil.unfpg_academico_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/cursos") public class CursoController {
 private final CursoRepository repo;
 public CursoController(CursoRepository repo) {this.repo=repo;}
 @GetMapping public List<Curso> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Curso buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Curso crear(@RequestBody Curso body) {body.codcur=null;  return repo.save(body);}
 @PutMapping("/{id}") public Curso actualizar(@PathVariable Integer id,@RequestBody Curso body) {var actual=buscar(id); actual.sercur=body.sercur;actual.nomcur=body.nomcur;actual.crecur=body.crecur;actual.blocur=body.blocur;actual.codprog=body.codprog; return repo.save(actual);}
 
}