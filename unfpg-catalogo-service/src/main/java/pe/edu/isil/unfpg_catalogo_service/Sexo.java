package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="sexo") public class Sexo {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codsex") public Integer codsex;
@Column(name="nomsex") public String nomsex;
@Column(name="estsex") public Boolean estsex = true;
}