package pe.edu.isil.plaza_ventas_service;
import jakarta.persistence.*;

@Entity
@Table(name="detalle_venta")
public class DetalleVenta {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="coddetv") public Integer coddetv;
    @Column(name="codven") public Integer codven;
    @Column(name="codpro") public Integer codpro;
    @Column(name="candetv") public Integer candetv;
    @Column(name="preundetv") public java.math.BigDecimal preundetv;
    @Column(name="subdetv") public java.math.BigDecimal subdetv;
    @Column(name="estdetv") public Boolean estdetv = true;
}
