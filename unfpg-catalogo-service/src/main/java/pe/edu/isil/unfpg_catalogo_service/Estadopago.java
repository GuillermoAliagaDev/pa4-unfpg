package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="estadopago") public class Estadopago {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codestp") public Integer codestp;
@Column(name="nomestp") public String nomestp;
@Column(name="estestp") public Boolean estestp = true;
}