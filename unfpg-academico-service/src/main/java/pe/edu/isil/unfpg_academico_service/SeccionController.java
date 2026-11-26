package pe.edu.isil.unfpg_academico_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/secciones") public class SeccionController {
 private final SeccionRepository repo;
 public SeccionController(SeccionRepository repo) {this.repo=repo;}
 @GetMapping public List<Seccion> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Seccion buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Seccion crear(@RequestBody Seccion body) {body.codsec=null;  return repo.save(body);}
 @PutMapping("/{id}") public Seccion actualizar(@PathVariable Integer id,@RequestBody Seccion body) {var actual=buscar(id); actual.capsec=body.capsec;actual.codcur=body.codcur;actual.coddoc=body.coddoc;actual.codper=body.codper; return repo.save(actual);}
 
}