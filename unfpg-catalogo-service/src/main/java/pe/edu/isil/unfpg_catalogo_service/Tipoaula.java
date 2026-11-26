package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="tipoaula") public class Tipoaula {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codtipa") public Integer codtipa;
@Column(name="nomtipa") public String nomtipa;
@Column(name="esttipa") public Boolean esttipa = true;
}