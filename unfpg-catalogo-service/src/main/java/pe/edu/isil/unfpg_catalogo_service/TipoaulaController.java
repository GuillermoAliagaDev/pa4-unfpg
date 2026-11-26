package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/tipoaula") public class TipoaulaController {
 private final TipoaulaRepository repo;
 public TipoaulaController(TipoaulaRepository repo) {this.repo=repo;}
 @GetMapping public List<Tipoaula> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Tipoaula buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Tipoaula crear(@RequestBody Tipoaula body) {body.codtipa=null; body.esttipa=true; return repo.save(body);}
 @PutMapping("/{id}") public Tipoaula actualizar(@PathVariable Integer id,@RequestBody Tipoaula body) {var actual=buscar(id); actual.nomtipa=body.nomtipa; return repo.save(actual);}
 @DeleteMapping("/{id}") public Tipoaula baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Tipoaula alta(@PathVariable Integer id) { return estado(id,true); }
private Tipoaula estado(Integer id, boolean activo) { var actual=buscar(id); actual.esttipa=activo; return repo.save(actual); }
}