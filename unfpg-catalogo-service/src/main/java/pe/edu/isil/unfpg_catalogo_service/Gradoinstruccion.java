package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="gradoinstruccion") public class Gradoinstruccion {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codgrai") public Integer codgrai;
@Column(name="nomgrai") public String nomgrai;
@Column(name="estgrai") public Boolean estgrai = true;
}