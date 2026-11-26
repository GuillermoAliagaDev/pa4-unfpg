package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="estadoprestamolibro") public class Estadoprestamolibro {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codestl") public Integer codestl;
@Column(name="nomestl") public String nomestl;
@Column(name="estestl") public Boolean estestl = true;
}