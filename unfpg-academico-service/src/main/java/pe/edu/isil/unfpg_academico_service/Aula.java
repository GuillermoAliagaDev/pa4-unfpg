package pe.edu.isil.unfpg_academico_service;
import jakarta.persistence.*;
@Entity @Table(name="aula") public class Aula {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codaul") public Integer codaul;
@Column(name="nomaul") public String nomaul;
@Column(name="capaul") public Integer capaul;
@Column(name="codubi") public Integer codubi;
@Column(name="codtipa") public Integer codtipa;
@Column(name="codesta") public Integer codesta;
}