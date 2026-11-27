package pe.edu.isil.plaza_compras_service;
import jakarta.persistence.*;

@Entity
@Table(name="orden_compra")
public class OrdenCompra {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codordc") public Integer codordc;
    @Column(name="numordc") public String numordc;
    @Column(name="fecordc") public java.time.LocalDateTime fecordc;
    @Column(name="codprv") public Integer codprv;
    @Column(name="totordc") public java.math.BigDecimal totordc;
    @Column(name="obsordc") public String obsordc;
    @Column(name="estordc") public Boolean estordc = true;
}
