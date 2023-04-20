package com.back.accesum.modelo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
@author Jorge Silva Helmunt Urueta Jordan Hernandez equipo Back-end 
*/

//Model of table regionals
@Data
@NoArgsConstructor
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


}
