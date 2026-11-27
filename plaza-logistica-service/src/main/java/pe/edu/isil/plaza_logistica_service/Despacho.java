package pe.edu.isil.plaza_logistica_service;
import jakarta.persistence.*;

@Entity
@Table(name="despacho")
public class Despacho {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="coddes") public Integer coddes;
    @Column(name="codped") public Integer codped;
    @Column(name="vehdes") public String vehdes;
    @Column(name="fecdes") public java.time.LocalDateTime fecdes;
    @Column(name="dirent") public String dirent;
    @Column(name="estdes") public Boolean estdes = true;
}
