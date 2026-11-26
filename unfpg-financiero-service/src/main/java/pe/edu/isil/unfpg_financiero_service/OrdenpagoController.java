package pe.edu.isil.unfpg_financiero_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/ordenes-pago") public class OrdenpagoController {
 private final OrdenpagoRepository repo;
 public OrdenpagoController(OrdenpagoRepository repo) {this.repo=repo;}
 @GetMapping public List<Ordenpago> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Ordenpago buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Ordenpago crear(@RequestBody Ordenpago body) {body.codordpag=null; body.estordpag=true; return repo.save(body);}
 @PutMapping("/{id}") public Ordenpago actualizar(@PathVariable Integer id,@RequestBody Ordenpago body) {var actual=buscar(id); actual.fecordpag=body.fecordpag;actual.monto=body.monto;actual.nummat=body.nummat;actual.codconp=body.codconp;actual.codmetp=body.codmetp;actual.codestp=body.codestp; return repo.save(actual);}
 @DeleteMapping("/{id}") public Ordenpago baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Ordenpago alta(@PathVariable Integer id) { return estado(id,true); }
private Ordenpago estado(Integer id, boolean activo) { var actual=buscar(id); actual.estordpag=activo; return repo.save(actual); }
}