package pe.edu.isil.libro_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/ejemplares") public class EjemplarlibroController {
 private final EjemplarlibroRepository repo;
 public EjemplarlibroController(EjemplarlibroRepository repo) {this.repo=repo;}
 @GetMapping public List<Ejemplarlibro> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Ejemplarlibro buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Ejemplarlibro crear(@RequestBody Ejemplarlibro body) {body.codeje=null; body.esteje=true; return repo.save(body);}
 @PutMapping("/{id}") public Ejemplarlibro actualizar(@PathVariable Integer id,@RequestBody Ejemplarlibro body) {var actual=buscar(id); actual.codlib=body.codlib;actual.codejemplar=body.codejemplar;actual.estadoeje=body.estadoeje; return repo.save(actual);}
 @DeleteMapping("/{id}") public Ejemplarlibro baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Ejemplarlibro alta(@PathVariable Integer id) { return estado(id,true); }
private Ejemplarlibro estado(Integer id, boolean activo) { var actual=buscar(id); actual.esteje=activo; return repo.save(actual); }
}