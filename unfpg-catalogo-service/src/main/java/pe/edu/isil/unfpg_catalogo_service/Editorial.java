package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="editorial") public class Editorial {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codedi") public Integer codedi;
@Column(name="nomedi") public String nomedi;
@Column(name="estedi") public Boolean estedi = true;
}