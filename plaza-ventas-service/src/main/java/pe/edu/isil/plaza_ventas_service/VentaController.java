package pe.edu.isil.plaza_ventas_service;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

import feign.FeignException;
import pe.edu.isil.plaza_ventas_service.client.ClienteClient;
import pe.edu.isil.plaza_ventas_service.dto.ClienteDTO;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaRepository repo;
    private final ClienteClient clienteClient;

    public VentaController(
            VentaRepository repo,
            ClienteClient clienteClient) {
        this.repo = repo;
        this.clienteClient = clienteClient;
    }

    @GetMapping
    public List<Venta> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Venta buscar(@PathVariable Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venta crear(@RequestBody Venta body) {

        validarCliente(body.codcli);

        body.codven = null;
        body.estven = true;

        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Venta actualizar(
            @PathVariable Integer id,
            @RequestBody Venta body) {

        var actual = buscar(id);

        validarCliente(body.codcli);

        actual.numcom = body.numcom;
        actual.fecven = body.fecven;
        actual.codcli = body.codcli;
        actual.codemp = body.codemp;
        actual.codmetp = body.codmetp;
        actual.totven = body.totven;

        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Venta baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Venta alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Venta estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estven = activo;
        return repo.save(actual);
    }

    // Validacion mediante OpenFeign
    private void validarCliente(Integer codcli) {

        if (codcli == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El codigo del cliente es obligatorio");
        }

        try {

            ClienteDTO cliente =
                    clienteClient.buscarPorId(codcli);

            if (cliente == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "El cliente no existe");
            }

            if (!Boolean.TRUE.equals(cliente.getEstcli())) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "El cliente esta deshabilitado");
            }

        } catch (FeignException.NotFound e) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El cliente no existe");

        } catch (FeignException e) {

            throw new ResponseStatusException(
                    HttpStatus.SERVICE_UNAVAILABLE,
                    "No se pudo consultar el microservicio Cliente");
        }
    }
}