package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="categorialibro") public class Categorialibro {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codcatl") public Integer codcatl;
@Column(name="nomcatl") public String nomcatl;
@Column(name="estcatl") public Boolean estcatl = true;
}