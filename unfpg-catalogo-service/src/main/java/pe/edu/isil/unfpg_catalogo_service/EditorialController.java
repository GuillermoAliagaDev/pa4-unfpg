package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/editorial") public class EditorialController {
 private final EditorialRepository repo;
 public EditorialController(EditorialRepository repo) {this.repo=repo;}
 @GetMapping public List<Editorial> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Editorial buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Editorial crear(@RequestBody Editorial body) {body.codedi=null; body.estedi=true; return repo.save(body);}
 @PutMapping("/{id}") public Editorial actualizar(@PathVariable Integer id,@RequestBody Editorial body) {var actual=buscar(id); actual.nomedi=body.nomedi; return repo.save(actual);}
 @DeleteMapping("/{id}") public Editorial baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Editorial alta(@PathVariable Integer id) { return estado(id,true); }
private Editorial estado(Integer id, boolean activo) { var actual=buscar(id); actual.estedi=activo; return repo.save(actual); }
}