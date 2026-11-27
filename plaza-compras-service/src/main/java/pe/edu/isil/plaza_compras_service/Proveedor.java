package pe.edu.isil.plaza_compras_service;
import jakarta.persistence.*;

@Entity
@Table(name="proveedor")
public class Proveedor {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codprv") public Integer codprv;
    @Column(name="razprv") public String razprv;
    @Column(name="rucprv") public String rucprv;
    @Column(name="telprv") public String telprv;
    @Column(name="corprv") public String corprv;
    @Column(name="dirprv") public String dirprv;
    @Column(name="estprv") public Boolean estprv = true;
}
