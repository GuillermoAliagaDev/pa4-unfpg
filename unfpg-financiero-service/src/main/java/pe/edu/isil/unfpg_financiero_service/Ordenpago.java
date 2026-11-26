package pe.edu.isil.unfpg_financiero_service;
import jakarta.persistence.*;
@Entity @Table(name="ordenpago") public class Ordenpago {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codordpag") public Integer codordpag;
@Column(name="fecordpag") public java.time.LocalDateTime fecordpag;
@Column(name="monto") public java.math.BigDecimal monto;
@Column(name="estordpag") public Boolean estordpag = true;
@Column(name="nummat") public Integer nummat;
@Column(name="codconp") public Integer codconp;
@Column(name="codmetp") public Integer codmetp;
@Column(name="codestp") public Integer codestp;
}