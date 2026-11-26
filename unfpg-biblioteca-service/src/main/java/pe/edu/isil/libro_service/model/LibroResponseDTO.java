package pe.edu.isil.libro_service.model;

public class LibroResponseDTO {

    private Integer codlib;
    private String isbnlib;
    private String titlib;
    private String autlib;
    private String deslib;
    private Boolean estlib;
    private Integer codcatl;
    private Integer codedi;

    // ---- Getters y Setters ----
    public Integer getCodlib() { return codlib; }
    public void setCodlib(Integer codlib) { this.codlib = codlib; }

    public String getIsbnlib() { return isbnlib; }
    public void setIsbnlib(String isbnlib) { this.isbnlib = isbnlib; }

    public String getTitlib() { return titlib; }
    public void setTitlib(String titlib) { this.titlib = titlib; }

    public String getAutlib() { return autlib; }
    public void setAutlib(String autlib) { this.autlib = autlib; }

    public String getDeslib() { return deslib; }
    public void setDeslib(String deslib) { this.deslib = deslib; }

    public Boolean getEstlib() { return estlib; }
    public void setEstlib(Boolean estlib) { this.estlib = estlib; }

    public Integer getCodcatl() { return codcatl; }
    public void setCodcatl(Integer codcatl) { this.codcatl = codcatl; }

    public Integer getCodedi() { return codedi; }
    public void setCodedi(Integer codedi) { this.codedi = codedi; }
}