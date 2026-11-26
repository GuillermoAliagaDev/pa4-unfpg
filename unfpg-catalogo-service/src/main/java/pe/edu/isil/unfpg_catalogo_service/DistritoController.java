package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/distrito") public class DistritoController {
 private final DistritoRepository repo;
 public DistritoController(DistritoRepository repo) {this.repo=repo;}
 @GetMapping public List<Distrito> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Distrito buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Distrito crear(@RequestBody Distrito body) {body.coddis=null; body.estdis=true; return repo.save(body);}
 @PutMapping("/{id}") public Distrito actualizar(@PathVariable Integer id,@RequestBody Distrito body) {var actual=buscar(id); actual.nomdis=body.nomdis; return repo.save(actual);}
 @DeleteMapping("/{id}") public Distrito baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Distrito alta(@PathVariable Integer id) { return estado(id,true); }
private Distrito estado(Integer id, boolean activo) { var actual=buscar(id); actual.estdis=activo; return repo.save(actual); }
}