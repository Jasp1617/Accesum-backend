package com.back.accesum.modelo.entity;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "parametros")
public class Parametros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametros")
    private Long id;

    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "id_sedes")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Sedes id_sedes;

    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "id_user")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private User id_user;

    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "id_rol")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Rol id_rol;


}
