package pe.edu.isil.unfpg_academico_service;
import jakarta.persistence.*;
@Entity @Table(name="traslado") public class Traslado {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codtra") public Integer codtra;
@Column(name="progori") public String progori;
@Column(name="uniori") public String uniori;
@Column(name="esttras") public Boolean esttras = true;
@Column(name="nummat") public Integer nummat;
}