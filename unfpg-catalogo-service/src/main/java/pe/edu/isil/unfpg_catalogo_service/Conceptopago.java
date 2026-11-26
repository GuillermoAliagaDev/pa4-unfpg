package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="conceptopago") public class Conceptopago {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codconp") public Integer codconp;
@Column(name="nomconp") public String nomconp;
@Column(name="desconp") public String desconp;
@Column(name="estconp") public Boolean estconp = true;
}