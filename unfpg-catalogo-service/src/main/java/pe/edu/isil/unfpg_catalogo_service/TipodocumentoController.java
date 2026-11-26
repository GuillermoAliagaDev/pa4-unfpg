package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/tipodocumento") public class TipodocumentoController {
 private final TipodocumentoRepository repo;
 public TipodocumentoController(TipodocumentoRepository repo) {this.repo=repo;}
 @GetMapping public List<Tipodocumento> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Tipodocumento buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Tipodocumento crear(@RequestBody Tipodocumento body) {body.codtipd=null; body.esttipd=true; return repo.save(body);}
 @PutMapping("/{id}") public Tipodocumento actualizar(@PathVariable Integer id,@RequestBody Tipodocumento body) {var actual=buscar(id); actual.nomtipd=body.nomtipd; return repo.save(actual);}
 @DeleteMapping("/{id}") public Tipodocumento baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Tipodocumento alta(@PathVariable Integer id) { return estado(id,true); }
private Tipodocumento estado(Integer id, boolean activo) { var actual=buscar(id); actual.esttipd=activo; return repo.save(actual); }
}