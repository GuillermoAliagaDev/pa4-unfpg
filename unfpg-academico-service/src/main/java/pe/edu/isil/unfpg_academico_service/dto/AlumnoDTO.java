package pe.edu.isil.unfpg_academico_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlumnoDTO {

    private Integer codalu;
    private String nomalu;
    private Boolean estalu;

    public Integer getCodalu() {
        return codalu;
    }

    public void setCodalu(Integer codalu) {
        this.codalu = codalu;
    }

    public String getNomalu() {
        return nomalu;
    }

    public void setNomalu(String nomalu) {
        this.nomalu = nomalu;
    }

    public Boolean getEstalu() {
        return estalu;
    }

    public void setEstalu(Boolean estalu) {
        this.estalu = estalu;
    }
}