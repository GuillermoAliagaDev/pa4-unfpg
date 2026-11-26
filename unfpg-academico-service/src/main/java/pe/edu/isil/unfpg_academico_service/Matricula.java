package pe.edu.isil.unfpg_academico_service;
import jakarta.persistence.*;
@Entity @Table(name="matricula") public class Matricula {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="nummat") public Integer nummat;
@Column(name="obsmat") public String obsmat;
@Column(name="fecmat", insertable=false, updatable=false) public java.time.LocalDateTime fecmat;
@Column(name="codalu") public Integer codalu;
@Column(name="codestm") public Integer codestm;
@Column(name="codtipm") public Integer codtipm;
@Column(name="codper") public Integer codper;
@Column(name="estmat") public Boolean estmat = true;
}