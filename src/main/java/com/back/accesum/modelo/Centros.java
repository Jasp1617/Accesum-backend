/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.accesum.modelo;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jorge Silva Helmunt Urueta Jordan Hernandez equipo Back-end
 */
@Getter
@Setter
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

    @NotNull(message="Este campo no puede estar vacio")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tbl_centros_tbl_regionals_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private regionales tbl_centros_tbl_regionals_id;

    // Constructor from Centros

    public Centros() {
    }

    // Getters and Setters from Centros

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @NotNull(message="Este campo no puede estar vacio")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tbl_centros_tbl_regionals_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Long getTbl_centros_codigo() {
        return tbl_centros_codigo;
    }

    public void setTbl_centros_codigo(Long tbl_centros_codigo) {
        this.tbl_centros_codigo = tbl_centros_codigo;
    }

    public String getTbl_centros_nombre() {
        return tbl_centros_nombre;
    }

    public void setTbl_centros_nombre(String tbl_centros_nombre) {
        this.tbl_centros_nombre = tbl_centros_nombre;
    }


}
