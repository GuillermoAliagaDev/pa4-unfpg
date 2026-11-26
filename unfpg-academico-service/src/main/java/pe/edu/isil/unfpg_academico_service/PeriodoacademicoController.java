package pe.edu.isil.unfpg_academico_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/periodoacademico") public class PeriodoacademicoController {
 private final PeriodoacademicoRepository repo;
 public PeriodoacademicoController(PeriodoacademicoRepository repo) {this.repo=repo;}
 @GetMapping public List<Periodoacademico> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Periodoacademico buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Periodoacademico crear(@RequestBody Periodoacademico body) {body.codper=null; body.estper=true; return repo.save(body);}
 @PutMapping("/{id}") public Periodoacademico actualizar(@PathVariable Integer id,@RequestBody Periodoacademico body) {var actual=buscar(id); actual.nomper=body.nomper;actual.fecini=body.fecini;actual.fecfin=body.fecfin;actual.desper=body.desper; return repo.save(actual);}
 @DeleteMapping("/{id}") public Periodoacademico baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Periodoacademico alta(@PathVariable Integer id) { return estado(id,true); }
private Periodoacademico estado(Integer id, boolean activo) { var actual=buscar(id); actual.estper=activo; return repo.save(actual); }
}