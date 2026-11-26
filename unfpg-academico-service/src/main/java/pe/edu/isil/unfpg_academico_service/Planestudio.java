package pe.edu.isil.unfpg_academico_service;
import jakarta.persistence.*;
@Entity @Table(name="planestudio") public class Planestudio {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codpla") public Integer codpla;
@Column(name="nompla") public String nompla;
@Column(name="despla") public String despla;
@Column(name="estpla") public Boolean estpla = true;
@Column(name="codprog") public Integer codprog;
}