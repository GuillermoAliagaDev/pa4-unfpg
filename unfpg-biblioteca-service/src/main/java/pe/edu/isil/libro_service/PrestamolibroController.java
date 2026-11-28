package pe.edu.isil.libro_service;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

import feign.FeignException;
import pe.edu.isil.libro_service.client.PersonaClient;
import pe.edu.isil.libro_service.dto.AlumnoDTO;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamolibroController {

    private final PrestamolibroRepository repo;
    private final PersonaClient personaClient;
    private final EjemplarlibroRepository ejemplares;

    public PrestamolibroController(
            PrestamolibroRepository repo,
            PersonaClient personaClient, EjemplarlibroRepository ejemplares) {
        this.ejemplares=ejemplares;
        this.repo = repo;
        this.personaClient = personaClient;
    }

    @PatchMapping("/{id}/devolver")
    @org.springframework.transaction.annotation.Transactional
    public Prestamolibro devolver(@PathVariable Integer id) {
        var actual = repo.bloquear(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Prestamo no encontrado"));
        if (!Boolean.TRUE.equals(actual.estpre) || Boolean.TRUE.equals(actual.devpre) || !(java.util.Objects.equals(actual.codestl,1) || java.util.Objects.equals(actual.codestl,3)))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Prestamo no disponible para devolucion");
        var ejemplar = ejemplares.findById(actual.codeje).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Ejemplar no encontrado"));
        actual.devpre=true; actual.fecdpre=java.time.LocalDate.now(); actual.codestl=2;
        ejemplar.estadoeje="DISPONIBLE"; ejemplares.save(ejemplar);
        return repo.save(actual);
    }

    @GetMapping
    public List<Prestamolibro> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Prestamolibro buscar(@PathVariable Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prestamolibro crear(@jakarta.validation.Valid @RequestBody Prestamolibro body) {

        validarAlumno(body.codalu);

        body.numpre = null;
        body.estpre = true;

        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Prestamolibro actualizar(
            @PathVariable Integer id,
            @jakarta.validation.Valid @RequestBody Prestamolibro body) {

        var actual = buscar(id);

        validarAlumno(body.codalu);

        actual.fecpre = body.fecpre;
        actual.fecdpre = body.fecdpre;
        actual.devpre = body.devpre;
        actual.codalu = body.codalu;
        actual.codeje = body.codeje;
        actual.codestl = body.codestl;

        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Prestamolibro baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Prestamolibro alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Prestamolibro estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estpre = activo;
        return repo.save(actual);
    }

    // Validacion mediante OpenFeign
    private void validarAlumno(Integer codalu) {

        if (codalu == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El codigo del alumno es obligatorio");
        }

        try {

            AlumnoDTO alumno = personaClient.buscarPorId(codalu);

            if (alumno == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "El alumno no existe");
            }

            if (!Boolean.TRUE.equals(alumno.getEstalu())) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "El alumno esta deshabilitado");
            }

        } catch (FeignException.NotFound e) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El alumno no existe");

        } catch (FeignException e) {

            throw new ResponseStatusException(
                    HttpStatus.SERVICE_UNAVAILABLE,
                    "No se pudo consultar el microservicio Persona");
        }
    }
}