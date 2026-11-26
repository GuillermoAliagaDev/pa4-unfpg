package pe.edu.isil.unfpg_academico_service;
import jakarta.persistence.*;
@Entity @Table(name="asistencia") public class Asistencia {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codasis") public Integer codasis;
@Column(name="fecasis") public java.time.LocalDateTime fecasis;
@Column(name="presente") public Boolean presente = false;
@Column(name="justificada") public Boolean justificada = false;
@Column(name="coddet") public Integer coddet;
@Column(name="codsec") public Integer codsec;
}