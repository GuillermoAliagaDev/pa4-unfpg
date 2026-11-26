package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="distrito") public class Distrito {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="coddis") public Integer coddis;
@Column(name="nomdis") public String nomdis;
@Column(name="estdis") public Boolean estdis = true;
}