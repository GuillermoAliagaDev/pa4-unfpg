package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/gradoinstruccion") public class GradoinstruccionController {
 private final GradoinstruccionRepository repo;
 public GradoinstruccionController(GradoinstruccionRepository repo) {this.repo=repo;}
 @GetMapping public List<Gradoinstruccion> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Gradoinstruccion buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Gradoinstruccion crear(@RequestBody Gradoinstruccion body) {body.codgrai=null; body.estgrai=true; return repo.save(body);}
 @PutMapping("/{id}") public Gradoinstruccion actualizar(@PathVariable Integer id,@RequestBody Gradoinstruccion body) {var actual=buscar(id); actual.nomgrai=body.nomgrai; return repo.save(actual);}
 @DeleteMapping("/{id}") public Gradoinstruccion baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Gradoinstruccion alta(@PathVariable Integer id) { return estado(id,true); }
private Gradoinstruccion estado(Integer id, boolean activo) { var actual=buscar(id); actual.estgrai=activo; return repo.save(actual); }
}