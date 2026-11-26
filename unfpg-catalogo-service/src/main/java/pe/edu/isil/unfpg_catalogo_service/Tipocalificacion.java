package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="tipocalificacion") public class Tipocalificacion {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codtipc") public Integer codtipc;
@Column(name="nomtipc") public String nomtipc;
@Column(name="esttipc") public Boolean esttipc = true;
}