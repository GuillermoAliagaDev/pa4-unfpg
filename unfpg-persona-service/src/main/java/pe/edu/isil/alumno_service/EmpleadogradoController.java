package pe.edu.isil.alumno_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.*;
@RestController @RequestMapping("/api/empleados/{id}/grados")
public class EmpleadogradoController {
 private final JdbcTemplate db;
 public EmpleadogradoController(JdbcTemplate db) {this.db=db;}
 public record Grado(@NotNull Integer codgrai,@NotBlank @Size(max=150) String institucion,@NotNull LocalDate anioobtencion,@NotBlank @Size(max=100) String nomesp) {}
 @GetMapping public List<Map<String,Object>> listar(@PathVariable Integer id) {return db.queryForList("SELECT * FROM empleadogrado WHERE codemp=?",id);}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Grado registrar(@PathVariable Integer id,@Valid @RequestBody Grado g) {db.update("INSERT INTO empleadogrado (codemp,codgrai,institucion,anioobtencion,nomesp) VALUES (?,?,?,?,?)",id,g.codgrai(),g.institucion(),g.anioobtencion(),g.nomesp());return g;}
}
