package pe.edu.isil.unfpg_aula_virtual_service;
import jakarta.persistence.*;
@Entity @Table(name="evaluacionlms") public class Evaluacionlms {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codeval") public Integer codeval;
@Column(name="nomeval") public String nomeval;
@Column(name="deseval") public String deseval;
@Column(name="feceval") public java.time.LocalDateTime feceval;
@Column(name="esteval") public Boolean esteval = true;
@Column(name="codcurl") public Integer codcurl;
}