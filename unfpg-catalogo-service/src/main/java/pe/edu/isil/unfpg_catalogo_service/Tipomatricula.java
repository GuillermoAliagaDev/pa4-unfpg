package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="tipomatricula") public class Tipomatricula {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codtipm") public Integer codtipm;
@Column(name="nomtipm") public String nomtipm;
@Column(name="destipm") public String destipm;
@Column(name="esttipm") public Boolean esttipm = true;
}