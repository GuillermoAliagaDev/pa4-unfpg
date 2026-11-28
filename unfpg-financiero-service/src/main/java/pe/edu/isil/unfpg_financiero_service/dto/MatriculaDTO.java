package pe.edu.isil.unfpg_financiero_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatriculaDTO {

    private Integer nummat;
    private Integer codalu;
    private Boolean estmat;

    public Integer getNummat() {
        return nummat;
    }

    public void setNummat(Integer nummat) {
        this.nummat = nummat;
    }

    public Integer getCodalu() {
        return codalu;
    }

    public void setCodalu(Integer codalu) {
        this.codalu = codalu;
    }

    public Boolean getEstmat() {
        return estmat;
    }

    public void setEstmat(Boolean estmat) {
        this.estmat = estmat;
    }
}