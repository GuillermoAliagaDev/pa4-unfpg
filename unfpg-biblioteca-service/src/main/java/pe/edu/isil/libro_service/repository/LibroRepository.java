package pe.edu.isil.libro_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.isil.libro_service.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

    boolean existsByIsbnlib(String isbnlib);
}