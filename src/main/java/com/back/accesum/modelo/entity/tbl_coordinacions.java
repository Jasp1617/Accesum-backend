package com.back.accesum.modelo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

//@author Jorge Silva Helmunt Urueta Jordan Hernandez equipo Back-end

//Model of table coordinacions
@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_coordinacions")
public class tbl_coordinacions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id ")
    private Long id;

    @Column(name = "tbl_coordinacions_codigo")
    private Long tbl_coordinacions_codigo;

    @Column(name = "tbl_coordinacions_nombre")
    private String tbl_coordinacions_nombre;

    @Column(name = "tbl_coordinacions_coordinador")
    private String tbl_coordinacions_coordinador;

    @ManyToOne(optional = false)
    @JoinColumn(name="tbl_coordinacions_tbl_centros_id", referencedColumnName = "id")
    private Centros tbl_coordinacions_tbl_centros_id;

    
}
