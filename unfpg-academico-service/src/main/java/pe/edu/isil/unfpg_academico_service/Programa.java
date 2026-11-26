package pe.edu.isil.unfpg_academico_service;
import jakarta.persistence.*;
@Entity @Table(name="programa") public class Programa {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codprog") public Integer codprog;
@Column(name="nomprog") public String nomprog;
@Column(name="estprog") public Boolean estprog = true;
@Column(name="codfac") public Integer codfac;
}