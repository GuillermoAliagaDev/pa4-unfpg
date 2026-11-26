package pe.edu.isil.unfpg_academico_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/detallematricula") public class DetallematriculaController {
 private final DetallematriculaRepository repo;
 public DetallematriculaController(DetallematriculaRepository repo) {this.repo=repo;}
 @GetMapping public List<Detallematricula> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Detallematricula buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Detallematricula crear(@RequestBody Detallematricula body) {body.coddet=null; body.estdet=true; return repo.save(body);}
 @PutMapping("/{id}") public Detallematricula actualizar(@PathVariable Integer id,@RequestBody Detallematricula body) {var actual=buscar(id); actual.nummat=body.nummat;actual.codsec=body.codsec; return repo.save(actual);}
 @DeleteMapping("/{id}") public Detallematricula baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Detallematricula alta(@PathVariable Integer id) { return estado(id,true); }
private Detallematricula estado(Integer id, boolean activo) { var actual=buscar(id); actual.estdet=activo; return repo.save(actual); }
}