package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="estadomatricula") public class Estadomatricula {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codestm") public Integer codestm;
@Column(name="nomestm") public String nomestm;
@Column(name="estestm") public Boolean estestm = true;
}