package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="diasemana") public class Diasemana {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="coddias") public Integer coddias;
@Column(name="nomdias") public String nomdias;
@Column(name="estdias") public Boolean estdias = true;
}