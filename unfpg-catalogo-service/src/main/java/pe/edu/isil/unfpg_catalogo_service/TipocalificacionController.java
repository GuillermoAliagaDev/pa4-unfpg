package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/tipocalificacion") public class TipocalificacionController {
 private final TipocalificacionRepository repo;
 public TipocalificacionController(TipocalificacionRepository repo) {this.repo=repo;}
 @GetMapping public List<Tipocalificacion> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Tipocalificacion buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Tipocalificacion crear(@RequestBody Tipocalificacion body) {body.codtipc=null; body.esttipc=true; return repo.save(body);}
 @PutMapping("/{id}") public Tipocalificacion actualizar(@PathVariable Integer id,@RequestBody Tipocalificacion body) {var actual=buscar(id); actual.nomtipc=body.nomtipc; return repo.save(actual);}
 @DeleteMapping("/{id}") public Tipocalificacion baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Tipocalificacion alta(@PathVariable Integer id) { return estado(id,true); }
private Tipocalificacion estado(Integer id, boolean activo) { var actual=buscar(id); actual.esttipc=activo; return repo.save(actual); }
}