package pe.edu.isil.unfpg_financiero_service;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

import feign.FeignException;
import pe.edu.isil.unfpg_financiero_service.client.AcademicoClient;
import pe.edu.isil.unfpg_financiero_service.dto.MatriculaDTO;

@RestController
@RequestMapping("/api/ordenes-pago")
public class OrdenpagoController {

    private final OrdenpagoRepository repo;
    private final AcademicoClient academicoClient;

    public OrdenpagoController(
            OrdenpagoRepository repo,
            AcademicoClient academicoClient) {
        this.repo = repo;
        this.academicoClient = academicoClient;
    }

    @GetMapping
    public List<Ordenpago> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Ordenpago buscar(@PathVariable Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ordenpago crear(@RequestBody Ordenpago body) {

        validarMatricula(body.nummat);

        body.codordpag = null;
        body.estordpag = true;

        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Ordenpago actualizar(
            @PathVariable Integer id,
            @RequestBody Ordenpago body) {

        var actual = buscar(id);

        validarMatricula(body.nummat);

        actual.fecordpag = body.fecordpag;
        actual.monto = body.monto;
        actual.nummat = body.nummat;
        actual.codconp = body.codconp;
        actual.codmetp = body.codmetp;
        actual.codestp = body.codestp;

        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Ordenpago baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Ordenpago alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Ordenpago estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estordpag = activo;
        return repo.save(actual);
    }

    // Validacion mediante OpenFeign
    private void validarMatricula(Integer nummat) {

        if (nummat == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El numero de matricula es obligatorio");
        }

        try {

            MatriculaDTO matricula =
                    academicoClient.buscarPorId(nummat);

            if (matricula == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "La matricula no existe");
            }

            if (!Boolean.TRUE.equals(matricula.getEstmat())) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "La matricula esta deshabilitada");
            }

        } catch (FeignException.NotFound e) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La matricula no existe");

        } catch (FeignException e) {

            throw new ResponseStatusException(
                    HttpStatus.SERVICE_UNAVAILABLE,
                    "No se pudo consultar el microservicio Academico");
        }
    }
}