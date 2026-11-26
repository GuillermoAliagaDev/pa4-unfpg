package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="estadoaula") public class Estadoaula {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codesta") public Integer codesta;
@Column(name="nomesta") public String nomesta;
@Column(name="estesta") public Boolean estesta = true;
}