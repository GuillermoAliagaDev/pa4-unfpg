package pe.edu.isil.unfpg_catalogo_service;
import jakarta.persistence.*;
@Entity @Table(name="rollms") public class Rollms {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codroll") public Integer codroll;
@Column(name="nomroll") public String nomroll;
@Column(name="estroll") public Boolean estroll = true;
}