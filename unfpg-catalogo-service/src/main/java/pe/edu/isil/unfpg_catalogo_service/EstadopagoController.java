package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/estados-pago") public class EstadopagoController {
 private final EstadopagoRepository repo;
 public EstadopagoController(EstadopagoRepository repo) {this.repo=repo;}
 @GetMapping public List<Estadopago> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Estadopago buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Estadopago crear(@RequestBody Estadopago body) {body.codestp=null; body.estestp=true; return repo.save(body);}
 @PutMapping("/{id}") public Estadopago actualizar(@PathVariable Integer id,@RequestBody Estadopago body) {var actual=buscar(id); actual.nomestp=body.nomestp; return repo.save(actual);}
 @DeleteMapping("/{id}") public Estadopago baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Estadopago alta(@PathVariable Integer id) { return estado(id,true); }
private Estadopago estado(Integer id, boolean activo) { var actual=buscar(id); actual.estestp=activo; return repo.save(actual); }
}