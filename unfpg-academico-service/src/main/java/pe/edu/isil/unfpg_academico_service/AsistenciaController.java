package pe.edu.isil.unfpg_academico_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/asistencias") public class AsistenciaController {
 private final AsistenciaRepository repo;
 public AsistenciaController(AsistenciaRepository repo) {this.repo=repo;}
 @GetMapping public List<Asistencia> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Asistencia buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Asistencia crear(@RequestBody Asistencia body) {body.codasis=null;  return repo.save(body);}
 @PutMapping("/{id}") public Asistencia actualizar(@PathVariable Integer id,@RequestBody Asistencia body) {var actual=buscar(id); actual.fecasis=body.fecasis;actual.presente=body.presente;actual.justificada=body.justificada;actual.coddet=body.coddet;actual.codsec=body.codsec; return repo.save(actual);}
 
}