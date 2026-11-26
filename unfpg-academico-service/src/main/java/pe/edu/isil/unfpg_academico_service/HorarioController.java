package pe.edu.isil.unfpg_academico_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/horarios") public class HorarioController {
 private final HorarioRepository repo;
 public HorarioController(HorarioRepository repo) {this.repo=repo;}
 @GetMapping public List<Horario> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Horario buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Horario crear(@RequestBody Horario body) {body.codhor=null;  return repo.save(body);}
 @PutMapping("/{id}") public Horario actualizar(@PathVariable Integer id,@RequestBody Horario body) {var actual=buscar(id); actual.codblo=body.codblo;actual.codsec=body.codsec;actual.coddias=body.coddias;actual.codaul=body.codaul; return repo.save(actual);}
 
}