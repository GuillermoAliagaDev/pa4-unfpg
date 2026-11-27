package pe.edu.isil.plaza_cliente_service;
import jakarta.persistence.*;

@Entity
@Table(name="tipodocumento")
public class Tipodocumento {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codtipd") public Integer codtipd;
    @Column(name="nomtipd") public String nomtipd;
    @Column(name="esttipd") public Boolean esttipd = true;
}
