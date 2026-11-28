package pe.edu.isil.alumno_service;
import jakarta.persistence.*;
@Entity @Table(name="docente") public class Docente {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="coddoc") public Integer coddoc;
@jakarta.validation.constraints.NotBlank
@Column(name="nomdoc") public String nomdoc;
@jakarta.validation.constraints.NotBlank
@Column(name="apepdoc") public String apepdoc;
@jakarta.validation.constraints.NotBlank
@Column(name="apemdoc") public String apemdoc;
@jakarta.validation.constraints.NotNull
@Column(name="fecnac") public java.time.LocalDate fecnac;
@jakarta.validation.constraints.NotBlank
@Column(name="numdoc") public String numdoc;
@jakarta.validation.constraints.NotBlank
@Column(name="nacdoc") public String nacdoc;
@jakarta.validation.constraints.NotBlank
@Column(name="dirdoc") public String dirdoc;
@Column(name="teldoc") public String teldoc;
@jakarta.validation.constraints.NotBlank
@Column(name="celdoc") public String celdoc;
@jakarta.validation.constraints.NotBlank
@Column(name="cordoc") public String cordoc;
@Column(name="estdoc") public Boolean estdoc = true;
@Column(name="credoc", insertable=false, updatable=false) public java.time.LocalDateTime credoc;
@jakarta.validation.constraints.NotNull
@Column(name="suedoc") public java.math.BigDecimal suedoc;
@jakarta.validation.constraints.NotNull
@Column(name="coddis") public Integer coddis;
@jakarta.validation.constraints.NotNull
@Column(name="codsex") public Integer codsex;
@jakarta.validation.constraints.NotNull
@Column(name="codtipd") public Integer codtipd;
@jakarta.validation.constraints.NotNull
@Column(name="codestc") public Integer codestc;
}