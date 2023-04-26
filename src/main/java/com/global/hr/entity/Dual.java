package com.global.hr.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dual_gen")
public class Dual {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
