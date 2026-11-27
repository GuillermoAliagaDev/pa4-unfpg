package pe.edu.isil.plaza_cliente_service;
import jakarta.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codcli") public Integer codcli;
    @Column(name="nomcli") public String nomcli;
    @Column(name="apecli") public String apecli;
    @Column(name="numdoc") public String numdoc;
    @Column(name="codtipd") public Integer codtipd;
    @Column(name="telcli") public String telcli;
    @Column(name="corcli") public String corcli;
    @Column(name="dircli") public String dircli;
    @Column(name="estcli") public Boolean estcli = true;
    @Column(name="crecli", insertable=false, updatable=false) public java.time.LocalDateTime crecli;
}
