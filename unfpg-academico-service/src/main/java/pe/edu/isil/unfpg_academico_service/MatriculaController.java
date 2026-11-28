package pe.edu.isil.unfpg_academico_service;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import pe.edu.isil.unfpg_academico_service.client.PersonaClient;
import pe.edu.isil.unfpg_academico_service.dto.AlumnoDTO;

import feign.FeignException;
import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaRepository repo;
    private final PersonaClient personaClient;

    public MatriculaController(
            MatriculaRepository repo,
            PersonaClient personaClient) {

        this.repo = repo;
        this.personaClient = personaClient;
    }

    @GetMapping
    public List<Matricula> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Matricula buscar(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(
            () -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Registro no encontrado"
            )
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Matricula crear(@RequestBody Matricula body) {

        validarAlumno(body.codalu);

        body.nummat = null;
        body.estmat = true;

        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Matricula actualizar(
            @PathVariable Integer id,
            @RequestBody Matricula body) {

        var actual = buscar(id);

        validarAlumno(body.codalu);

        actual.obsmat = body.obsmat;
        actual.codalu = body.codalu;
        actual.codestm = body.codestm;
        actual.codtipm = body.codtipm;
        actual.codper = body.codper;

        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Matricula baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Matricula alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Matricula estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estmat = activo;
        return repo.save(actual);
    }

    // Validacion mediante OpenFeign
    private void validarAlumno(Integer codalu) {

        if (codalu == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El codigo del alumno es obligatorio"
            );
        }

        try {

            AlumnoDTO alumno = personaClient.buscarPorId(codalu);

            if (alumno == null) {
                throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El alumno no existe"
                );
            }

            if (!Boolean.TRUE.equals(alumno.getEstalu())) {
                throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El alumno se encuentra deshabilitado"
                );
            }

        } catch (FeignException.NotFound e) {

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El alumno no existe"
            );

        } catch (FeignException e) {

            throw new ResponseStatusException(
                HttpStatus.SERVICE_UNAVAILABLE,
                "No se pudo consultar el microservicio Persona"
            );
        }
    }
}