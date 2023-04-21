package com.back.accesum.modelo.entity;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jorge Silva Helmunt Urueta Jordan Hernandez equipo Back-end
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_centros")
public class Centros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tbl_centros_codigo")
    private Long tbl_centros_codigo;

    @Column(name = "tbl_centros_nombre")
    private String tbl_centros_nombre;

    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="tbl_centros_tbl_regionals_id")
    private regionales tbl_centros_tbl_regionals_id;


}
