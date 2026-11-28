package pe.edu.isil.plaza_pagos_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoDTO {

    private Integer codped;
    private String numped;
    private Boolean estped;
    private BigDecimal totped;

    public Integer getCodped() {
        return codped;
    }

    public void setCodped(Integer codped) {
        this.codped = codped;
    }

    public String getNumped() {
        return numped;
    }

    public void setNumped(String numped) {
        this.numped = numped;
    }

    public Boolean getEstped() {
        return estped;
    }

    public void setEstped(Boolean estped) {
        this.estped = estped;
    }

    public BigDecimal getTotped() {
        return totped;
    }

    public void setTotped(BigDecimal totped) {
        this.totped = totped;
    }
}