package pe.edu.isil.plaza_producto_service;
import jakarta.persistence.*;

@Entity
@Table(name="producto")
public class Producto {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codpro") public Integer codpro;
    @Column(name="nompro") public String nompro;
    @Column(name="despro") public String despro;
    @Column(name="prepro") public java.math.BigDecimal prepro;
    @Column(name="stopro") public Integer stopro;
    @Column(name="codcat") public Integer codcat;
    @Column(name="codprv") public Integer codprv;
    @Column(name="estpro") public Boolean estpro = true;
    @Column(name="crepro", insertable=false, updatable=false) public java.time.LocalDateTime crepro;
}
