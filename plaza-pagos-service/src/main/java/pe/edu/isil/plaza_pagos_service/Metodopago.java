package pe.edu.isil.plaza_pagos_service;
import jakarta.persistence.*;

@Entity
@Table(name="metodopago")
public class Metodopago {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="codmetp") public Integer codmetp;
    @Column(name="nommetp") public String nommetp;
    @Column(name="estmetp") public Boolean estmetp = true;
}
