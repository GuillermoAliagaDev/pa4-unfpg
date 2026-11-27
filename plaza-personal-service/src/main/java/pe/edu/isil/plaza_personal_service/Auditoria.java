package pe.edu.isil.plaza_personal_service;
import jakarta.persistence.*;

@Entity
@Table(name="auditoria")
public class Auditoria {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codaud") public Integer codaud;
    @Column(name="codusu") public Integer codusu;
    @Column(name="accaud") public String accaud;
    @Column(name="fecaud") public java.time.LocalDateTime fecaud;
    @Column(name="estaud") public Boolean estaud = true;
}
