package pe.edu.isil.unfpg_academico_service;
import jakarta.persistence.*;
@Entity @Table(name="periodoacademico") public class Periodoacademico {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codper") public Integer codper;
@Column(name="nomper") public String nomper;
@Column(name="fecini") public java.time.LocalDate fecini;
@Column(name="fecfin") public java.time.LocalDate fecfin;
@Column(name="desper") public String desper;
@Column(name="estper") public Boolean estper = true;
}