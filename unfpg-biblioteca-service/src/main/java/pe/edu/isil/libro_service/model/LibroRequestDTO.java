package pe.edu.isil.libro_service.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LibroRequestDTO {

    @Size(max = 20)
    private String isbnlib;

    @NotBlank(message = "El titulo es obligatorio")
    @Size(max = 200)
    private String titlib;

    @NotBlank(message = "El autor es obligatorio")
    @Size(max = 150)
    private String autlib;

    @Size(max = 300)
    private String deslib;

    @NotNull(message = "La categoria (codcatl) es obligatoria")
    private Integer codcatl;

    @NotNull(message = "La editorial (codedi) es obligatoria")
    private Integer codedi;

    // ---- Getters y Setters ----
    public String getIsbnlib() { return isbnlib; }
    public void setIsbnlib(String isbnlib) { this.isbnlib = isbnlib; }

    public String getTitlib() { return titlib; }
    public void setTitlib(String titlib) { this.titlib = titlib; }

    public String getAutlib() { return autlib; }
    public void setAutlib(String autlib) { this.autlib = autlib; }

    public String getDeslib() { return deslib; }
    public void setDeslib(String deslib) { this.deslib = deslib; }

    public Integer getCodcatl() { return codcatl; }
    public void setCodcatl(Integer codcatl) { this.codcatl = codcatl; }

    public Integer getCodedi() { return codedi; }
    public void setCodedi(Integer codedi) { this.codedi = codedi; }
}