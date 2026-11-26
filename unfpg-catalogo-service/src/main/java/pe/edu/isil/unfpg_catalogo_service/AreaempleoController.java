package pe.edu.isil.unfpg_catalogo_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/areaempleo") public class AreaempleoController {
 private final AreaempleoRepository repo;
 public AreaempleoController(AreaempleoRepository repo) {this.repo=repo;}
 @GetMapping public List<Areaempleo> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Areaempleo buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Areaempleo crear(@RequestBody Areaempleo body) {body.codare=null; body.estare=true; return repo.save(body);}
 @PutMapping("/{id}") public Areaempleo actualizar(@PathVariable Integer id,@RequestBody Areaempleo body) {var actual=buscar(id); actual.nomare=body.nomare; return repo.save(actual);}
 @DeleteMapping("/{id}") public Areaempleo baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Areaempleo alta(@PathVariable Integer id) { return estado(id,true); }
private Areaempleo estado(Integer id, boolean activo) { var actual=buscar(id); actual.estare=activo; return repo.save(actual); }
}