package pe.edu.isil.unfpg_seguridad_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
@RestController @RequestMapping("/api/usuarios/{id}/roles")
public class UsuarioRolController {
 private final JdbcTemplate db;
 public UsuarioRolController(JdbcTemplate db) {this.db=db;}
 @GetMapping public List<Map<String,Object>> listar(@PathVariable Integer id) {return db.queryForList("SELECT codusu,codrol FROM usuariorol WHERE codusu=?",id);}
 @PostMapping("/{rol}") @ResponseStatus(HttpStatus.CREATED) public Map<String,Integer> asignar(@PathVariable Integer id,@PathVariable Integer rol) {
 if(db.queryForObject("SELECT COUNT(*) FROM usuario WHERE codusu=? AND estusu=1",Integer.class,id)==0 || db.queryForObject("SELECT COUNT(*) FROM rol WHERE codrol=? AND estrol=1",Integer.class,rol)==0) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario o rol activo no encontrado");
 db.update("INSERT INTO usuariorol(codusu,codrol) VALUES (?,?)",id,rol); return Map.of("codusu",id,"codrol",rol);}
}
