package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/cargo") public class CargoController {
 private final CargoRepository repo;
 public CargoController(CargoRepository repo) {this.repo=repo;}
 @GetMapping public List<Cargo> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Cargo buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Cargo crear(@RequestBody Cargo body) {body.codcar=null; body.estcar=true; return repo.save(body);}
 @PutMapping("/{id}") public Cargo actualizar(@PathVariable Integer id,@RequestBody Cargo body) {var actual=buscar(id); actual.nomcar=body.nomcar; return repo.save(actual);}
 @DeleteMapping("/{id}") public Cargo baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Cargo alta(@PathVariable Integer id) { return estado(id,true); }
private Cargo estado(Integer id, boolean activo) { var actual=buscar(id); actual.estcar=activo; return repo.save(actual); }
}