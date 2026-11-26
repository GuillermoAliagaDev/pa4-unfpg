package pe.edu.isil.unfpg_academico_service;
import jakarta.persistence.*;
@Entity @Table(name="facultad") public class Facultad {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codfac") public Integer codfac;
@Column(name="nomfac") public String nomfac;
@Column(name="desfac") public String desfac;
@Column(name="estfac") public Boolean estfac = true;
}