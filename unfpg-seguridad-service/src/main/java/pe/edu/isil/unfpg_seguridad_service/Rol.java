package pe.edu.isil.unfpg_seguridad_service;
import jakarta.persistence.*;
@Entity @Table(name="rol") public class Rol {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codrol") public Integer codrol;
@Column(name="nomrol") public String nomrol;
@Column(name="estrol") public Boolean estrol = true;
}