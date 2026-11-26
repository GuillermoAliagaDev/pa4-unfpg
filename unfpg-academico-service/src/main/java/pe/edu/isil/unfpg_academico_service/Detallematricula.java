package pe.edu.isil.unfpg_academico_service;
import jakarta.persistence.*;
@Entity @Table(name="detallematricula") public class Detallematricula {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="coddet") public Integer coddet;
@Column(name="estdet") public Boolean estdet = true;
@Column(name="nummat") public Integer nummat;
@Column(name="codsec") public Integer codsec;
}