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
    
    @ManyToOne(optional = false)
    @JoinColumn(name="fichas_id", referencedColumnName = "id")
    private tbl_fichas tbl_fichas;

    @ManyToOne(optional = false)
    @JoinColumn(name="rol_id", referencedColumnName = "id")
    private Rol rol_id;
    
}
