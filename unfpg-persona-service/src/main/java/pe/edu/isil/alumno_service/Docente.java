package pe.edu.isil.alumno_service;
import jakarta.persistence.*;
@Entity @Table(name="docente") public class Docente {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="coddoc") public Integer coddoc;
@Column(name="nomdoc") public String nomdoc;
@Column(name="apepdoc") public String apepdoc;
@Column(name="apemdoc") public String apemdoc;
@Column(name="fecnac") public java.time.LocalDate fecnac;
@Column(name="numdoc") public String numdoc;
@Column(name="nacdoc") public String nacdoc;
@Column(name="dirdoc") public String dirdoc;
@Column(name="teldoc") public String teldoc;
@Column(name="celdoc") public String celdoc;
@Column(name="cordoc") public String cordoc;
@Column(name="estdoc") public Boolean estdoc = true;
@Column(name="credoc", insertable=false, updatable=false) public java.time.LocalDateTime credoc;
@Column(name="suedoc") public java.math.BigDecimal suedoc;
@Column(name="coddis") public Integer coddis;
@Column(name="codsex") public Integer codsex;
@Column(name="codtipd") public Integer codtipd;
@Column(name="codestc") public Integer codestc;
}