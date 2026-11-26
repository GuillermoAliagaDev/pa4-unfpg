package pe.edu.isil.unfpg_academico_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/programa") public class ProgramaController {
 private final ProgramaRepository repo;
 public ProgramaController(ProgramaRepository repo) {this.repo=repo;}
 @GetMapping public List<Programa> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Programa buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Programa crear(@RequestBody Programa body) {body.codprog=null; body.estprog=true; return repo.save(body);}
 @PutMapping("/{id}") public Programa actualizar(@PathVariable Integer id,@RequestBody Programa body) {var actual=buscar(id); actual.nomprog=body.nomprog;actual.codfac=body.codfac; return repo.save(actual);}
 @DeleteMapping("/{id}") public Programa baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Programa alta(@PathVariable Integer id) { return estado(id,true); }
private Programa estado(Integer id, boolean activo) { var actual=buscar(id); actual.estprog=activo; return repo.save(actual); }
}