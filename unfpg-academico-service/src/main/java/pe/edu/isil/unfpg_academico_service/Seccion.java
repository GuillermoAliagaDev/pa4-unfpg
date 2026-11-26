package pe.edu.isil.unfpg_academico_service;
import jakarta.persistence.*;
@Entity @Table(name="seccion") public class Seccion {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codsec") public Integer codsec;
@Column(name="capsec") public Integer capsec = 30;
@Column(name="codcur") public Integer codcur;
@Column(name="coddoc") public Integer coddoc;
@Column(name="codper") public Integer codper;
}