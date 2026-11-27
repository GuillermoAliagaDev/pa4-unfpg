package pe.edu.isil.plaza_logistica_service;
import jakarta.persistence.*;

@Entity
@Table(name="sucursal")
public class Sucursal {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codsuc") public Integer codsuc;
    @Column(name="nomsuc") public String nomsuc;
    @Column(name="dirsuc") public String dirsuc;
    @Column(name="telsuc") public String telsuc;
    @Column(name="estsuc") public Boolean estsuc = true;
}
