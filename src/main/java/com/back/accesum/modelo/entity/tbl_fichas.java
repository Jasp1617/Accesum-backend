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
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jorge Silva
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_fichas")
public class tbl_fichas implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id ")
    private Long id;
    
    @Column(name = "tbl_fichas_codigo")
    private String tbl_fichas_codigo;
        
    @Column(name = "fichas_grupo")
    private String fichas_grupo;
    
    @Column(name = "programa")
    private String programa;
    
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="tbl_fichas_tbl_coordinacions")
    private tbl_coordinacions tbl_fichas_tbl_coordinacions ;


}
