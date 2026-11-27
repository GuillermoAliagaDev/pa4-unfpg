package pe.edu.isil.plaza_logistica_service;
import jakarta.persistence.*;

@Entity
@Table(name="inventario")
public class Inventario {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codinv") public Integer codinv;
    @Column(name="codpro") public Integer codpro;
    @Column(name="codalm") public Integer codalm;
    @Column(name="caninv") public Integer caninv;
    @Column(name="estinv") public Boolean estinv = true;
}
