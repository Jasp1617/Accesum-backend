package com.back.accesum.modelo;

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

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@author Jorge Silva Helmunt Urueta Jordan Hernandez equipo Back-end

//Model of table coordinacions
@Getter
@Setter
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

    @NotNull(message="Este campo no puede estar vacio")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tbl_coordinacions_tbl_centros_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Centros tbl_coordinacions_tbl_centros_id;

    //Constructor of table coordnacions
    public tbl_coordinacions() {
    }
    
    //Getters and setters from table coordnacions
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getTbl_coordinacions_codigo() {
        return tbl_coordinacions_codigo;
    }

    public void setTbl_coordinacions_codigo(Long tbl_coordinacions_codigo) {
        this.tbl_coordinacions_codigo = tbl_coordinacions_codigo;
    }

    public String getTbl_coordinacions_nombre() {
        return tbl_coordinacions_nombre;
    }

    public void setTbl_coordinacions_nombre(String tbl_coordinacions_nombre) {
        this.tbl_coordinacions_nombre = tbl_coordinacions_nombre;
    }

    public String getTbl_coordinacions_coordinador() {
        return tbl_coordinacions_coordinador;
    }

    public void setTbl_coordinacions_coordinador(String tbl_coordinacions_coordinador) {
        this.tbl_coordinacions_coordinador = tbl_coordinacions_coordinador;
    }


    
}
