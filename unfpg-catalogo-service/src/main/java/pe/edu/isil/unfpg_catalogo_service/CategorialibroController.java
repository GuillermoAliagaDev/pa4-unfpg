package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/categorialibro") public class CategorialibroController {
 private final CategorialibroRepository repo;
 public CategorialibroController(CategorialibroRepository repo) {this.repo=repo;}
 @GetMapping public List<Categorialibro> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Categorialibro buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Categorialibro crear(@RequestBody Categorialibro body) {body.codcatl=null; body.estcatl=true; return repo.save(body);}
 @PutMapping("/{id}") public Categorialibro actualizar(@PathVariable Integer id,@RequestBody Categorialibro body) {var actual=buscar(id); actual.nomcatl=body.nomcatl; return repo.save(actual);}
 @DeleteMapping("/{id}") public Categorialibro baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Categorialibro alta(@PathVariable Integer id) { return estado(id,true); }
private Categorialibro estado(Integer id, boolean activo) { var actual=buscar(id); actual.estcatl=activo; return repo.save(actual); }
}