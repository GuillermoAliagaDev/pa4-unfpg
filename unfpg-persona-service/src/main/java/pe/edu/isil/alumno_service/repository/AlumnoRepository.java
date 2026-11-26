package pe.edu.isil.alumno_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.isil.alumno_service.model.Alumno;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    Optional<Alumno> findByNumdoc(String numdoc);

    boolean existsByNumdoc(String numdoc);

    boolean existsByCoralu(String coralu);
}