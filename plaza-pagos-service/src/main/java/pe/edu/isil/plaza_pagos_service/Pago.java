package pe.edu.isil.plaza_pagos_service;
import jakarta.persistence.*;

@Entity
@Table(name="pago")
public class Pago {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codpag") public Integer codpag;
    @Column(name="numpag") public String numpag;
    @Column(name="codped") public Integer codped;
    @Column(name="codmetp") public Integer codmetp;
    @Column(name="monpag") public java.math.BigDecimal monpag;
    @Column(name="fecpag") public java.time.LocalDateTime fecpag;
    @Column(name="estpag") public Boolean estpag = true;
}
