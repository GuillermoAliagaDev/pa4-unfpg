package pe.edu.isil.libro_service;
import jakarta.persistence.*;
@Entity @Table(name="prestamolibro") public class Prestamolibro {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="numpre") public Integer numpre;
@Column(name="fecpre") public java.time.LocalDate fecpre;
@Column(name="fecdpre") public java.time.LocalDate fecdpre;
@Column(name="devpre") public Boolean devpre = false;
@Column(name="estpre") public Boolean estpre = true;
@Column(name="codalu") public Integer codalu;
@Column(name="codeje") public Integer codeje;
@Column(name="codestl") public Integer codestl;
}