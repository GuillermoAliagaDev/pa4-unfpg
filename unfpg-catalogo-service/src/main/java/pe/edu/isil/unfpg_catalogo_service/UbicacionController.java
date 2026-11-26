package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/ubicacion") public class UbicacionController {
 private final UbicacionRepository repo;
 public UbicacionController(UbicacionRepository repo) {this.repo=repo;}
 @GetMapping public List<Ubicacion> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Ubicacion buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Ubicacion crear(@RequestBody Ubicacion body) {body.codubi=null; body.estubi=true; return repo.save(body);}
 @PutMapping("/{id}") public Ubicacion actualizar(@PathVariable Integer id,@RequestBody Ubicacion body) {var actual=buscar(id); actual.nomubi=body.nomubi;actual.desubi=body.desubi; return repo.save(actual);}
 @DeleteMapping("/{id}") public Ubicacion baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Ubicacion alta(@PathVariable Integer id) { return estado(id,true); }
private Ubicacion estado(Integer id, boolean activo) { var actual=buscar(id); actual.estubi=activo; return repo.save(actual); }
}