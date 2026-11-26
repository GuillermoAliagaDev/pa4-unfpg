package pe.edu.isil.alumno_service.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AlumnoResponseDTO {

    private Integer codalu;
    private String nomalu;
    private String apepalu;
    private String apemalu;
    private LocalDate fecnac;
    private String numdoc;
    private String nacalu;
    private String diralu;
    private String telalu;
    private String celalu;
    private String coralu;
    private Boolean estalu;
    private LocalDateTime crealu;
    private Integer coddis;
    private Integer codsex;
    private Integer codtipd;
    private Integer codestc;

    // ---- Getters y Setters ----
    public Integer getCodalu() { return codalu; }
    public void setCodalu(Integer codalu) { this.codalu = codalu; }

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

    public Boolean getEstalu() { return estalu; }
    public void setEstalu(Boolean estalu) { this.estalu = estalu; }

    public LocalDateTime getCrealu() { return crealu; }
    public void setCrealu(LocalDateTime crealu) { this.crealu = crealu; }

    public Integer getCoddis() { return coddis; }
    public void setCoddis(Integer coddis) { this.coddis = coddis; }

    public Integer getCodsex() { return codsex; }
    public void setCodsex(Integer codsex) { this.codsex = codsex; }

    public Integer getCodtipd() { return codtipd; }
    public void setCodtipd(Integer codtipd) { this.codtipd = codtipd; }

    public Integer getCodestc() { return codestc; }
    public void setCodestc(Integer codestc) { this.codestc = codestc; }
}