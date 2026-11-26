package pe.edu.isil.unfpg_aula_virtual_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/matriculas-lms") public class MatriculalmsController {
 private final MatriculalmsRepository repo;
 public MatriculalmsController(MatriculalmsRepository repo) {this.repo=repo;}
 @GetMapping public List<Matriculalms> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Matriculalms buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Matriculalms crear(@RequestBody Matriculalms body) {body.nummatl=null; body.estmatl=true; return repo.save(body);}
 @PutMapping("/{id}") public Matriculalms actualizar(@PathVariable Integer id,@RequestBody Matriculalms body) {var actual=buscar(id); actual.fecmatl=body.fecmatl;actual.codalu=body.codalu;actual.codcurl=body.codcurl;actual.codroll=body.codroll; return repo.save(actual);}
 @DeleteMapping("/{id}") public Matriculalms baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Matriculalms alta(@PathVariable Integer id) { return estado(id,true); }
private Matriculalms estado(Integer id, boolean activo) { var actual=buscar(id); actual.estmatl=activo; return repo.save(actual); }
}