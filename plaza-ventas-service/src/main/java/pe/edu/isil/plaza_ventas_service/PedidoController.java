package pe.edu.isil.plaza_ventas_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoRepository repo;

    public PedidoController(PedidoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Pedido> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Pedido buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido crear(@RequestBody Pedido body) {
        body.codped = null;
        body.estped = true;
        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Pedido actualizar(@PathVariable Integer id, @RequestBody Pedido body) {
        var actual = buscar(id);
        
actual.numped = body.numped;        actual.fecped = body.fecped;        actual.codcli = body.codcli;        actual.codpro = body.codpro;        actual.codmetp = body.codmetp;        actual.canped = body.canped;        actual.preuni = body.preuni;        actual.subtot = body.subtot;        actual.igv = body.igv;        actual.totped = body.totped;        actual.obsped = body.obsped;
        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Pedido baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Pedido alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Pedido estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estped = activo;
        return repo.save(actual);
    }

}
