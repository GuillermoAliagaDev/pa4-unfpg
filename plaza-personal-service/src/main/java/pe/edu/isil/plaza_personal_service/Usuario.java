package pe.edu.isil.plaza_personal_service;
import jakarta.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codusu") public Integer codusu;
    @Column(name="nomusu") public String nomusu;
    @Column(name="clausu") public String clausu;
    @Column(name="codemp") public Integer codemp;
    @Column(name="rolusu") public String rolusu;
    @Column(name="estusu") public Boolean estusu = true;
}
