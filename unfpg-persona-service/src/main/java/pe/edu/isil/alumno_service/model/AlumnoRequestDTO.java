package pe.edu.isil.alumno_service.model;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class AlumnoRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50)
    private String nomalu;

    @NotBlank(message = "El apellido paterno es obligatorio")
    @Size(max = 40)
    private String apepalu;

    @NotBlank(message = "El apellido materno es obligatorio")
    @Size(max = 40)
    private String apemalu;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser anterior a hoy")
    private LocalDate fecnac;

    @NotBlank(message = "El numero de documento es obligatorio")
    @Size(max = 20)
    private String numdoc;

    @NotBlank(message = "La nacionalidad es obligatoria")
    @Size(max = 20)
    private String nacalu;

    @NotBlank(message = "La direccion es obligatoria")
    private String diralu;

    @Size(max = 15)
    private String telalu;

    @Size(max = 15)
    private String celalu;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no tiene un formato valido")
    @Size(max = 100)
    private String coralu;

    @NotNull(message = "El distrito (coddis) es obligatorio")
    private Integer coddis;

    @NotNull(message = "El sexo (codsex) es obligatorio")
    private Integer codsex;

    @NotNull(message = "El tipo de documento (codtipd) es obligatorio")
    private Integer codtipd;

    @NotNull(message = "El estado civil (codestc) es obligatorio")
    private Integer codestc;

    // ---- Getters y Setters ----
    public String getNomalu() { return nomalu; }
    public void setNomalu(String nomalu) { this.nomalu = nomalu; }

    public String getApepalu() { return apepalu; }
    public void setApepalu(String apepalu) { this.apepalu = apepalu; }

    public String getApemalu() { return apemalu; }
    public void setApemalu(String apemalu) { this.apemalu = apemalu; }

    public LocalDate getFecnac() { return fecnac; }
    public void setFecnac(LocalDate fecnac) { this.fecnac = fecnac; }

    public String getNumdoc() { return numdoc; }
    public void setNumdoc(String numdoc) { this.numdoc = numdoc; }

    public String getNacalu() { return nacalu; }
    public void setNacalu(String nacalu) { this.nacalu = nacalu; }

    public String getDiralu() { return diralu; }
    public void setDiralu(String diralu) { this.diralu = diralu; }

    public String getTelalu() { return telalu; }
    public void setTelalu(String telalu) { this.telalu = telalu; }

    public String getCelalu() { return celalu; }
    public void setCelalu(String celalu) { this.celalu = celalu; }

    public String getCoralu() { return coralu; }
    public void setCoralu(String coralu) { this.coralu = coralu; }

    public Integer getCoddis() { return coddis; }
    public void setCoddis(Integer coddis) { this.coddis = coddis; }

    public Integer getCodsex() { return codsex; }
    public void setCodsex(Integer codsex) { this.codsex = codsex; }

    public Integer getCodtipd() { return codtipd; }
    public void setCodtipd(Integer codtipd) { this.codtipd = codtipd; }

    public Integer getCodestc() { return codestc; }
    public void setCodestc(Integer codestc) { this.codestc = codestc; }
}