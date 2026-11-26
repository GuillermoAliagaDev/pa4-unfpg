package pe.edu.isil.unfpg_academico_service;
import jakarta.persistence.*;
@Entity @Table(name="calificacion") public class Calificacion {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codcal") public Integer codcal;
@Column(name="feccal") public java.time.LocalDateTime feccal;
@Column(name="nota") public java.math.BigDecimal nota;
@Column(name="coddet") public Integer coddet;
@Column(name="codsec") public Integer codsec;
@Column(name="codtipc") public Integer codtipc;
}