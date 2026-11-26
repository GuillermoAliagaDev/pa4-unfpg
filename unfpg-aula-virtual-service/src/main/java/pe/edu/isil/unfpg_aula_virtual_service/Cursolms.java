package pe.edu.isil.unfpg_aula_virtual_service;
import jakarta.persistence.*;
@Entity @Table(name="cursolms") public class Cursolms {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codcurl") public Integer codcurl;
@Column(name="codpla") public Integer codpla;
@Column(name="estcurl") public Boolean estcurl = true;
@Column(name="codsec") public Integer codsec;
}