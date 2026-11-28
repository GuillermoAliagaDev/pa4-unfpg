package pe.edu.isil.plaza_ventas_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDTO {

    private Integer codcli;
    private String nomcli;
    private Boolean estcli;

    public Integer getCodcli() {
        return codcli;
    }

    public void setCodcli(Integer codcli) {
        this.codcli = codcli;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public Boolean getEstcli() {
        return estcli;
    }

    public void setEstcli(Boolean estcli) {
        this.estcli = estcli;
    }
}