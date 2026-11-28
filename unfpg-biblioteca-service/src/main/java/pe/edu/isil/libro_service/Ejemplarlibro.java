package pe.edu.isil.libro_service;
import jakarta.persistence.*;
@Entity @Table(name="ejemplarlibro") public class Ejemplarlibro {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codeje") public Integer codeje;
@jakarta.validation.constraints.NotNull
@Column(name="codlib") public Integer codlib;
@jakarta.validation.constraints.NotBlank
@Column(name="codejemplar") public String codejemplar;
@jakarta.validation.constraints.NotBlank
@Column(name="estadoeje") public String estadoeje = "DISPONIBLE";
@Column(name="esteje") public Boolean esteje = true;
}