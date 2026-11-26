package pe.edu.isil.unfpg_seguridad_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/roles") public class RolController {
 private final RolRepository repo;
 public RolController(RolRepository repo) {this.repo=repo;}
 @GetMapping public List<Rol> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Rol buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Rol crear(@RequestBody Rol body) {body.codrol=null; body.estrol=true; return repo.save(body);}
 @PutMapping("/{id}") public Rol actualizar(@PathVariable Integer id,@RequestBody Rol body) {var actual=buscar(id); actual.nomrol=body.nomrol; return repo.save(actual);}
 @DeleteMapping("/{id}") public Rol baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Rol alta(@PathVariable Integer id) { return estado(id,true); }
private Rol estado(Integer id, boolean activo) { var actual=buscar(id); actual.estrol=activo; return repo.save(actual); }
}