package pe.edu.isil.alumno_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/docentes") public class DocenteController {
 private final DocenteRepository repo;
 public DocenteController(DocenteRepository repo) {this.repo=repo;}
 @GetMapping public List<Docente> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Docente buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Docente crear(@jakarta.validation.Valid @RequestBody Docente body) {body.coddoc=null; body.estdoc=true; return repo.save(body);}
 @PutMapping("/{id}") public Docente actualizar(@PathVariable Integer id,@jakarta.validation.Valid @RequestBody Docente body) {var actual=buscar(id); actual.nomdoc=body.nomdoc;actual.apepdoc=body.apepdoc;actual.apemdoc=body.apemdoc;actual.fecnac=body.fecnac;actual.numdoc=body.numdoc;actual.nacdoc=body.nacdoc;actual.dirdoc=body.dirdoc;actual.teldoc=body.teldoc;actual.celdoc=body.celdoc;actual.cordoc=body.cordoc;actual.suedoc=body.suedoc;actual.coddis=body.coddis;actual.codsex=body.codsex;actual.codtipd=body.codtipd;actual.codestc=body.codestc; return repo.save(actual);}
 @DeleteMapping("/{id}") public Docente baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Docente alta(@PathVariable Integer id) { return estado(id,true); }
private Docente estado(Integer id, boolean activo) { var actual=buscar(id); actual.estdoc=activo; return repo.save(actual); }
}