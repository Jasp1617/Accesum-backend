/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.accesum.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
@author Jorge Silva Helmunt Urueta Jordan Hernandez equipo Back-end 
*/

//Model of table regionals

@Entity
@Table(name = "tbl_regionals")
public class regionales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id ")
    private Long id;

    @Column(name = "tbl_regionals_codigo")
    private Long tbl_regionals_codigo;

    @Column(name = "tbl_regionals_nombre")
    private String tbl_regionals_nombre;

    @Column(name = "tbl_regionals_director")
    private String tbl_regionals_director;

   //Constructor of table regionales

    public regionales() {
    }
 //Getters and setters from regionales

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTbl_regionals_codigo() {
        return tbl_regionals_codigo;
    }

    public void setTbl_regionals_codigo(Long tbl_regionals_codigo) {
        this.tbl_regionals_codigo = tbl_regionals_codigo;
    }

    public String getTbl_regionals_nombre() {
        return tbl_regionals_nombre;
    }

    public void setTbl_regionals_nombre(String tbl_regionals_nombre) {
        this.tbl_regionals_nombre = tbl_regionals_nombre;
    }

    public String getTbl_regionals_director() {
        return tbl_regionals_director;
    }

    public void setTbl_regionals_director(String tbl_regionals_director) {
        this.tbl_regionals_director = tbl_regionals_director;
    }


}
