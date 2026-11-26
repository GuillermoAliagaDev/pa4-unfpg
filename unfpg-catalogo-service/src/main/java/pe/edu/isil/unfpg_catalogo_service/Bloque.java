package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="bloque") public class Bloque {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codblo") public Integer codblo;
@Column(name="nomblo") public String nomblo;
@Column(name="iniblo") public java.time.LocalTime iniblo;
@Column(name="finblo") public java.time.LocalTime finblo;
@Column(name="estblo") public Boolean estblo = true;
}