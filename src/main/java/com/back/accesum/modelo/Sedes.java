package com.back.accesum.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_sedes")
public class Sedes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sedes")
    private Long id_sedes;

    @Column(name = "tbl_sedes_codigo")
    private String tbl_sedes_codigo;
    
    @Column(name = "sedes_nombre")
    private String sedes_nombre;
        
    @Column(name = "sedes_ciudad")
    private String sedes_ciudad;
            
    @Column(name = "sede_direccion")
    private String sede_direccion;
              
    @Column(name = "sede_centros_id")
    private String sede_centros_id;  
    
    @Column(name = "sede_cordinacions")
    private String sede_cordinacions;
    

    public Long getId_sedes() {
        return id_sedes;
    }

    public void setId_sedes(Long id_sedes) {
        this.id_sedes = id_sedes;
    }

    public String getTbl_sedes_codigo() {
        return tbl_sedes_codigo;
    }

    public void setTbl_sedes_codigo(String tbl_sedes_codigo) {
        this.tbl_sedes_codigo = tbl_sedes_codigo;
    }

    public String getSedes_nombre() {
        return sedes_nombre;
    }

    public void setSedes_nombre(String sedes_nombre) {
        this.sedes_nombre = sedes_nombre;
    }

    public String getSedes_ciudad() {
        return sedes_ciudad;
    }

    public void setSedes_ciudad(String sedes_ciudad) {
        this.sedes_ciudad = sedes_ciudad;
    }

    public String getSede_direccion() {
        return sede_direccion;
    }

    public void setSede_direccion(String sede_direccion) {
        this.sede_direccion = sede_direccion;
    }

    public String getSede_centros_id() {
        return sede_centros_id;
    }

    public void setSede_centros_id(String sede_centros_id) {
        this.sede_centros_id = sede_centros_id;
    }

    public String getSede_cordinacions() {
        return sede_cordinacions;
    }

    public void setSede_cordinacions(String sede_cordinacions) {
        this.sede_cordinacions = sede_cordinacions;
    }
    
    
    
}
