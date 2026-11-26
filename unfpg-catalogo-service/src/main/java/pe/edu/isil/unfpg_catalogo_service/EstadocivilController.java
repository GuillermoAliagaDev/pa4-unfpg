package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/estadocivil") public class EstadocivilController {
 private final EstadocivilRepository repo;
 public EstadocivilController(EstadocivilRepository repo) {this.repo=repo;}
 @GetMapping public List<Estadocivil> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Estadocivil buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Estadocivil crear(@RequestBody Estadocivil body) {body.codestc=null; body.estestc=true; return repo.save(body);}
 @PutMapping("/{id}") public Estadocivil actualizar(@PathVariable Integer id,@RequestBody Estadocivil body) {var actual=buscar(id); actual.nomestc=body.nomestc; return repo.save(actual);}
 @DeleteMapping("/{id}") public Estadocivil baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Estadocivil alta(@PathVariable Integer id) { return estado(id,true); }
private Estadocivil estado(Integer id, boolean activo) { var actual=buscar(id); actual.estestc=activo; return repo.save(actual); }
}