package pe.edu.isil.libro_service;
import jakarta.persistence.*;
@Entity @Table(name="ejemplarlibro") public class Ejemplarlibro {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codeje") public Integer codeje;
@Column(name="codlib") public Integer codlib;
@Column(name="codejemplar") public String codejemplar;
@Column(name="estadoeje") public String estadoeje = "DISPONIBLE";
@Column(name="esteje") public Boolean esteje = true;
}