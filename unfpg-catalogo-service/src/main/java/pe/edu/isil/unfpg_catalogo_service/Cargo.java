package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="cargo") public class Cargo {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codcar") public Integer codcar;
@Column(name="nomcar") public String nomcar;
@Column(name="estcar") public Boolean estcar = true;
}