package pe.edu.isil.plaza_logistica_service;
import jakarta.persistence.*;

@Entity
@Table(name="almacen")
public class Almacen {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codalm") public Integer codalm;
    @Column(name="nomalm") public String nomalm;
    @Column(name="ubialm") public String ubialm;
    @Column(name="codsuc") public Integer codsuc;
    @Column(name="estalm") public Boolean estalm = true;
}
