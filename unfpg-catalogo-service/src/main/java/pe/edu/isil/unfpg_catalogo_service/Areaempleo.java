package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="areaempleo") public class Areaempleo {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codare") public Integer codare;
@Column(name="nomare") public String nomare;
@Column(name="estare") public Boolean estare = true;
}