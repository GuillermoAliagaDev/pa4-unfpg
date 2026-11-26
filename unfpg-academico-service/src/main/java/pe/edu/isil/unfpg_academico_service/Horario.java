package pe.edu.isil.unfpg_academico_service;
import jakarta.persistence.*;
@Entity @Table(name="horario") public class Horario {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codhor") public Integer codhor;
@Column(name="codblo") public Integer codblo;
@Column(name="codsec") public Integer codsec;
@Column(name="coddias") public Integer coddias;
@Column(name="codaul") public Integer codaul;
}