package pe.edu.isil.plaza_ventas_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductoDTO {

    private Integer codpro;
    private String nompro;
    private Integer stopro;
    private Boolean estpro;

    public Integer getCodpro() {
        return codpro;
    }

    public void setCodpro(Integer codpro) {
        this.codpro = codpro;
    }

    public String getNompro() {
        return nompro;
    }

    public void setNompro(String nompro) {
        this.nompro = nompro;
    }

    public Integer getStopro() {
        return stopro;
    }

    public void setStopro(Integer stopro) {
        this.stopro = stopro;
    }

    public Boolean getEstpro() {
        return estpro;
    }

    public void setEstpro(Boolean estpro) {
        this.estpro = estpro;
    }
}