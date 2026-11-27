package pe.edu.isil.plaza_personal_service;
import jakarta.persistence.*;

@Entity
@Table(name="empleado")
public class Empleado {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codemp") public Integer codemp;
    @Column(name="numdoc") public String numdoc;
    @Column(name="nomemp") public String nomemp;
    @Column(name="apeemp") public String apeemp;
    @Column(name="caremp") public String caremp;
    @Column(name="codsuc") public Integer codsuc;
    @Column(name="estemp") public Boolean estemp = true;
}
