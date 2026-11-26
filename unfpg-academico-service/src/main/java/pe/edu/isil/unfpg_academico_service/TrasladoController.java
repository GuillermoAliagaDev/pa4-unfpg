package pe.edu.isil.unfpg_academico_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/traslado") public class TrasladoController {
 private final TrasladoRepository repo;
 public TrasladoController(TrasladoRepository repo) {this.repo=repo;}
 @GetMapping public List<Traslado> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Traslado buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Traslado crear(@RequestBody Traslado body) {body.codtra=null; body.esttras=true; return repo.save(body);}
 @PutMapping("/{id}") public Traslado actualizar(@PathVariable Integer id,@RequestBody Traslado body) {var actual=buscar(id); actual.progori=body.progori;actual.uniori=body.uniori;actual.nummat=body.nummat; return repo.save(actual);}
 @DeleteMapping("/{id}") public Traslado baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Traslado alta(@PathVariable Integer id) { return estado(id,true); }
private Traslado estado(Integer id, boolean activo) { var actual=buscar(id); actual.esttras=activo; return repo.save(actual); }
}