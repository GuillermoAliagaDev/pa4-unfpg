package pe.edu.isil.plaza_ventas_service;
import jakarta.persistence.*;

@Entity
@Table(name="venta")
public class Venta {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codven") public Integer codven;
    @Column(name="numcom") public String numcom;
    @Column(name="fecven") public java.time.LocalDateTime fecven;
    @Column(name="codcli") public Integer codcli;
    @Column(name="codemp") public Integer codemp;
    @Column(name="codmetp") public Integer codmetp;
    @Column(name="totven") public java.math.BigDecimal totven;
    @Column(name="estven") public Boolean estven = true;
}
