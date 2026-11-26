package pe.edu.isil.unfpg_academico_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/facultad") public class FacultadController {
 private final FacultadRepository repo;
 public FacultadController(FacultadRepository repo) {this.repo=repo;}
 @GetMapping public List<Facultad> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Facultad buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Facultad crear(@RequestBody Facultad body) {body.codfac=null; body.estfac=true; return repo.save(body);}
 @PutMapping("/{id}") public Facultad actualizar(@PathVariable Integer id,@RequestBody Facultad body) {var actual=buscar(id); actual.nomfac=body.nomfac;actual.desfac=body.desfac; return repo.save(actual);}
 @DeleteMapping("/{id}") public Facultad baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Facultad alta(@PathVariable Integer id) { return estado(id,true); }
private Facultad estado(Integer id, boolean activo) { var actual=buscar(id); actual.estfac=activo; return repo.save(actual); }
}