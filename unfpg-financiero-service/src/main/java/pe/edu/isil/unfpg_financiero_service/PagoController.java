package pe.edu.isil.unfpg_financiero_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/pagos") public class PagoController {
 private final PagoRepository repo;
 public PagoController(PagoRepository repo) {this.repo=repo;}
 @GetMapping public List<Pago> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Pago buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Pago crear(@RequestBody Pago body) {body.codpag=null; body.estpag=true; return repo.save(body);}
 @PutMapping("/{id}") public Pago actualizar(@PathVariable Integer id,@RequestBody Pago body) {var actual=buscar(id); actual.fecpag=body.fecpag;actual.montopag=body.montopag;actual.codordpag=body.codordpag; return repo.save(actual);}
 @DeleteMapping("/{id}") public Pago baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Pago alta(@PathVariable Integer id) { return estado(id,true); }
private Pago estado(Integer id, boolean activo) { var actual=buscar(id); actual.estpag=activo; return repo.save(actual); }
}