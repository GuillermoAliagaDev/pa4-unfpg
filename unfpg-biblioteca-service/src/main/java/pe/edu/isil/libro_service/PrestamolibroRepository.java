package pe.edu.isil.libro_service;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PrestamolibroRepository extends JpaRepository<Prestamolibro,Integer> {
 @org.springframework.data.jpa.repository.Lock(jakarta.persistence.LockModeType.PESSIMISTIC_WRITE)
 @org.springframework.data.jpa.repository.Query("select p from Prestamolibro p where p.numpre=:id")
 java.util.Optional<Prestamolibro> bloquear(@org.springframework.data.repository.query.Param("id") Integer id);
}