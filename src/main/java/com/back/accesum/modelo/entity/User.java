package com.back.accesum.modelo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import javax.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    
    @Column(name = "name")
    private String nombre;
    
    @Column(name = "document")
    private Long document;
    
    @Email(message="no es una dirección de correo bien formada")
    @Column(name = "email")
    private String email;
        
    @Column(name = "password")
    private String password;

    @Column(name = "detalles")
    private String detalles;
    
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="fichas_id")
    private tbl_fichas tbl_fichas;


    
}
