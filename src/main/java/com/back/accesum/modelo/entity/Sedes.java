package com.back.accesum.modelo.entity;

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


@Data
@NoArgsConstructor
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
              
    @ManyToOne(optional = false)
    @JoinColumn(name="sede_centros_id")
    private Centros sede_centros_id;  
    
    @ManyToOne(optional = false)
    @JoinColumn(name="sede_cordinacions", referencedColumnName = "id")
    private tbl_coordinacions sede_cordinacions;
    
    
}
