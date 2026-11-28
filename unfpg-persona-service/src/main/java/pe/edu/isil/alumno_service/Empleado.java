package pe.edu.isil.alumno_service;
import jakarta.persistence.*;
@Entity @Table(name="empleado") public class Empleado {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codemp") public Integer codemp;
@jakarta.validation.constraints.NotBlank
@Column(name="nomemp") public String nomemp;
@jakarta.validation.constraints.NotBlank
@Column(name="apepemp") public String apepemp;
@jakarta.validation.constraints.NotBlank
@Column(name="apememp") public String apememp;
@jakarta.validation.constraints.NotNull
@Column(name="fecnac") public java.time.LocalDate fecnac;
@jakarta.validation.constraints.NotBlank
@Column(name="numdoc") public String numdoc;
@jakarta.validation.constraints.NotBlank
@Column(name="nacemp") public String nacemp;
@jakarta.validation.constraints.NotBlank
@Column(name="diremp") public String diremp;
@Column(name="telemp") public String telemp;
@jakarta.validation.constraints.NotBlank
@Column(name="celemp") public String celemp;
@jakarta.validation.constraints.NotBlank
@Column(name="coremp") public String coremp;
@Column(name="estemp") public Boolean estemp = true;
@Column(name="creemp", insertable=false, updatable=false) public java.time.LocalDateTime creemp;
@jakarta.validation.constraints.NotNull
@Column(name="sueemp") public java.math.BigDecimal sueemp;
@jakarta.validation.constraints.NotNull
@Column(name="codare") public Integer codare;
@jakarta.validation.constraints.NotNull
@Column(name="codcar") public Integer codcar;
@jakarta.validation.constraints.NotNull
@Column(name="coddis") public Integer coddis;
@jakarta.validation.constraints.NotNull
@Column(name="codsex") public Integer codsex;
@jakarta.validation.constraints.NotNull
@Column(name="codtipd") public Integer codtipd;
@jakarta.validation.constraints.NotNull
@Column(name="codestc") public Integer codestc;
}