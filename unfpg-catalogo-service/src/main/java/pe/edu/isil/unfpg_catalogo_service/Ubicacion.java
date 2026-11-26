package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="ubicacion") public class Ubicacion {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codubi") public Integer codubi;
@Column(name="nomubi") public String nomubi;
@Column(name="desubi") public String desubi;
@Column(name="estubi") public Boolean estubi = true;
}