package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="estadocivil") public class Estadocivil {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codestc") public Integer codestc;
@Column(name="nomestc") public String nomestc;
@Column(name="estestc") public Boolean estestc = true;
}