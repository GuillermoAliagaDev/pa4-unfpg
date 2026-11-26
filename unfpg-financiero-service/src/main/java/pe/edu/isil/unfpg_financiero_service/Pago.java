package pe.edu.isil.unfpg_financiero_service;
import jakarta.persistence.*;
@Entity @Table(name="pago") public class Pago {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codpag") public Integer codpag;
@Column(name="fecpag") public java.time.LocalDateTime fecpag;
@Column(name="montopag") public java.math.BigDecimal montopag;
@Column(name="estpag") public Boolean estpag = true;
@Column(name="codordpag") public Integer codordpag;
}