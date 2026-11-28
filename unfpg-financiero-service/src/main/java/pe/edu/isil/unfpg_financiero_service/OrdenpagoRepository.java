package pe.edu.isil.unfpg_financiero_service;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrdenpagoRepository extends JpaRepository<Ordenpago,Integer> {
 @org.springframework.data.jpa.repository.Query(value="SELECT COALESCE(SUM(GREATEST(o.monto - COALESCE((SELECT SUM(p.montopag) FROM pago p WHERE p.codordpag=o.codordpag AND p.estpag=1),0),0)),0) FROM ordenpago o WHERE o.nummat=:nummat AND o.estordpag=1 AND o.codestp<>4", nativeQuery=true)
 java.math.BigDecimal calcularDeuda(@org.springframework.data.repository.query.Param("nummat") Integer nummat);
}