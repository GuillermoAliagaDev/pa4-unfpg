package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/estadoprestamolibro") public class EstadoprestamolibroController {
 private final EstadoprestamolibroRepository repo;
 public EstadoprestamolibroController(EstadoprestamolibroRepository repo) {this.repo=repo;}
 @GetMapping public List<Estadoprestamolibro> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Estadoprestamolibro buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Estadoprestamolibro crear(@RequestBody Estadoprestamolibro body) {body.codestl=null; body.estestl=true; return repo.save(body);}
 @PutMapping("/{id}") public Estadoprestamolibro actualizar(@PathVariable Integer id,@RequestBody Estadoprestamolibro body) {var actual=buscar(id); actual.nomestl=body.nomestl; return repo.save(actual);}
 @DeleteMapping("/{id}") public Estadoprestamolibro baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Estadoprestamolibro alta(@PathVariable Integer id) { return estado(id,true); }
private Estadoprestamolibro estado(Integer id, boolean activo) { var actual=buscar(id); actual.estestl=activo; return repo.save(actual); }
}