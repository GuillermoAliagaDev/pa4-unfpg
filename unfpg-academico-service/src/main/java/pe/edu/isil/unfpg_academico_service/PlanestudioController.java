package pe.edu.isil.unfpg_academico_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/planestudio") public class PlanestudioController {
 private final PlanestudioRepository repo;
 public PlanestudioController(PlanestudioRepository repo) {this.repo=repo;}
 @GetMapping public List<Planestudio> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Planestudio buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Planestudio crear(@RequestBody Planestudio body) {body.codpla=null; body.estpla=true; return repo.save(body);}
 @PutMapping("/{id}") public Planestudio actualizar(@PathVariable Integer id,@RequestBody Planestudio body) {var actual=buscar(id); actual.nompla=body.nompla;actual.despla=body.despla;actual.codprog=body.codprog; return repo.save(actual);}
 @DeleteMapping("/{id}") public Planestudio baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Planestudio alta(@PathVariable Integer id) { return estado(id,true); }
private Planestudio estado(Integer id, boolean activo) { var actual=buscar(id); actual.estpla=activo; return repo.save(actual); }
}