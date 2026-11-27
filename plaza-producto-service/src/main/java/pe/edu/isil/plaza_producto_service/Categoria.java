package pe.edu.isil.plaza_producto_service;
import jakarta.persistence.*;

@Entity
@Table(name="categoria")
public class Categoria {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codcat") public Integer codcat;
    @Column(name="nomcat") public String nomcat;
    @Column(name="descat") public String descat;
    @Column(name="estcat") public Boolean estcat = true;
}
