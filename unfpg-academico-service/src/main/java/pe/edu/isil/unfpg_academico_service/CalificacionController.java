package pe.edu.isil.unfpg_academico_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/calificaciones") public class CalificacionController {
 private final CalificacionRepository repo;
 public CalificacionController(CalificacionRepository repo) {this.repo=repo;}
 @GetMapping public List<Calificacion> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Calificacion buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Calificacion crear(@RequestBody Calificacion body) {body.codcal=null;  return repo.save(body);}
 @PutMapping("/{id}") public Calificacion actualizar(@PathVariable Integer id,@RequestBody Calificacion body) {var actual=buscar(id); actual.feccal=body.feccal;actual.nota=body.nota;actual.coddet=body.coddet;actual.codsec=body.codsec;actual.codtipc=body.codtipc; return repo.save(actual);}
 
}