package pe.edu.isil.unfpg_academico_service;
import jakarta.persistence.*;
@Entity @Table(name="curso") public class Curso {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codcur") public Integer codcur;
@Column(name="sercur") public String sercur;
@Column(name="nomcur") public String nomcur;
@Column(name="crecur") public Integer crecur = 0;
@Column(name="blocur") public Integer blocur = 0;
@Column(name="codprog") public Integer codprog;
}