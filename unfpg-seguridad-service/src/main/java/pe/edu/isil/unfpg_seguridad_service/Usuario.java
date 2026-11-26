package pe.edu.isil.unfpg_seguridad_service;
import jakarta.persistence.*;
@Entity @Table(name="usuario") public class Usuario {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codusu") public Integer codusu;
@Column(name="nomusu") public String nomusu;
@com.fasterxml.jackson.annotation.JsonProperty(access=com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY) @Column(name="clausu") public String clausu;
@Column(name="corusu") public String corusu;
@Column(name="creusu", insertable=false, updatable=false) public java.time.LocalDateTime creusu;
@Column(name="estusu") public Boolean estusu = true;
@Column(name="codalu") public Integer codalu;
@Column(name="coddoc") public Integer coddoc;
@Column(name="codemp") public Integer codemp;
}