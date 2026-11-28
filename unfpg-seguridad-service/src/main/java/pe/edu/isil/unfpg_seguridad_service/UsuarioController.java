package pe.edu.isil.unfpg_seguridad_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/usuarios") public class UsuarioController {
 private final UsuarioRepository repo;
 private final org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder encoder = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
 private String hash(String clave) { if(clave==null || clave.isBlank() || clave.getBytes(java.nio.charset.StandardCharsets.UTF_8).length>72) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Clave obligatoria, maximo 72 bytes"); return encoder.encode(clave); }
 public record Login(String nomusu,String clausu) {}
 @PostMapping("/login") public java.util.Map<String,Object> login(@RequestBody Login body) { var u=body.nomusu()==null?null:repo.findByNomusu(body.nomusu()).orElse(null); if(u==null || !Boolean.TRUE.equals(u.estusu) || body.clausu()==null || !encoder.matches(body.clausu(),u.clausu)) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Credenciales invalidas"); return java.util.Map.of("codusu",u.codusu,"nomusu",u.nomusu,"autenticado",true); }
 public UsuarioController(UsuarioRepository repo) {this.repo=repo;}
 @GetMapping public List<Usuario> listar() {return repo.findAll();}
 @GetMapping("/{id}") public Usuario buscar(@PathVariable Integer id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Usuario crear(@RequestBody Usuario body) {body.clausu=hash(body.clausu); body.codusu=null; body.estusu=true; return repo.save(body);}
 @PutMapping("/{id}") public Usuario actualizar(@PathVariable Integer id,@RequestBody Usuario body) {var actual=buscar(id); actual.nomusu=body.nomusu;if(body.clausu!=null) actual.clausu=hash(body.clausu);actual.corusu=body.corusu;actual.codalu=body.codalu;actual.coddoc=body.coddoc;actual.codemp=body.codemp; return repo.save(actual);}
 @DeleteMapping("/{id}") public Usuario baja(@PathVariable Integer id) { return estado(id,false); }
@PatchMapping("/{id}/habilitar") public Usuario alta(@PathVariable Integer id) { return estado(id,true); }
private Usuario estado(Integer id, boolean activo) { var actual=buscar(id); actual.estusu=activo; return repo.save(actual); }
}