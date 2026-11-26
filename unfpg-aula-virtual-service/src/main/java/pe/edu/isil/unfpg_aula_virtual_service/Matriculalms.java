package pe.edu.isil.unfpg_aula_virtual_service;
import jakarta.persistence.*;
@Entity @Table(name="matriculalms") public class Matriculalms {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="nummatl") public Integer nummatl;
@Column(name="fecmatl") public java.time.LocalDateTime fecmatl;
@Column(name="estmatl") public Boolean estmatl = true;
@Column(name="codalu") public Integer codalu;
@Column(name="codcurl") public Integer codcurl;
@Column(name="codroll") public Integer codroll;
}