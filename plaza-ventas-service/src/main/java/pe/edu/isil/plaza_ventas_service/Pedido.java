package pe.edu.isil.plaza_ventas_service;
import jakarta.persistence.*;

@Entity
@Table(name="pedido")
public class Pedido {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codped") public Integer codped;
    @Column(name="numped") public String numped;
    @Column(name="fecped") public java.time.LocalDateTime fecped;
    @Column(name="codcli") public Integer codcli;
    @Column(name="codpro") public Integer codpro;
    @Column(name="codmetp") public Integer codmetp;
    @Column(name="canped") public Integer canped;
    @Column(name="preuni") public java.math.BigDecimal preuni;
    @Column(name="subtot") public java.math.BigDecimal subtot;
    @Column(name="igv") public java.math.BigDecimal igv;
    @Column(name="totped") public java.math.BigDecimal totped;
    @Column(name="obsped") public String obsped;
    @Column(name="estped") public Boolean estped = true;
}
