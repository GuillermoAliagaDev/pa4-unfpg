package pe.edu.isil.unfpg_aula_virtual_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/cursos-lms") public class CursolmsController {
 private final CursolmsRepository repo;
 public CursolmsController(CursolmsRepository repo) {this.repo=repo;}
 @GetMapping public List<Cursolms> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Cursolms buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Cursolms crear(@RequestBody Cursolms body) {body.codcurl=null; body.estcurl=true; return repo.save(body);}
 @PutMapping("/{id}") public Cursolms actualizar(@PathVariable Integer id,@RequestBody Cursolms body) {var actual=buscar(id); actual.codpla=body.codpla;actual.codsec=body.codsec; return repo.save(actual);}
 @DeleteMapping("/{id}") public Cursolms baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Cursolms alta(@PathVariable Integer id) { return estado(id,true); }
private Cursolms estado(Integer id, boolean activo) { var actual=buscar(id); actual.estcurl=activo; return repo.save(actual); }
}