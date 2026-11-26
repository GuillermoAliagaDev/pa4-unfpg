package pe.edu.isil.alumno_service;
import jakarta.persistence.*;
@Entity @Table(name="empleado") public class Empleado {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codemp") public Integer codemp;
@Column(name="nomemp") public String nomemp;
@Column(name="apepemp") public String apepemp;
@Column(name="apememp") public String apememp;
@Column(name="fecnac") public java.time.LocalDate fecnac;
@Column(name="numdoc") public String numdoc;
@Column(name="nacemp") public String nacemp;
@Column(name="diremp") public String diremp;
@Column(name="telemp") public String telemp;
@Column(name="celemp") public String celemp;
@Column(name="coremp") public String coremp;
@Column(name="estemp") public Boolean estemp = true;
@Column(name="creemp", insertable=false, updatable=false) public java.time.LocalDateTime creemp;
@Column(name="sueemp") public java.math.BigDecimal sueemp;
@Column(name="codare") public Integer codare;
@Column(name="codcar") public Integer codcar;
@Column(name="coddis") public Integer coddis;
@Column(name="codsex") public Integer codsex;
@Column(name="codtipd") public Integer codtipd;
@Column(name="codestc") public Integer codestc;
}