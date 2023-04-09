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

@Getter
@Setter
@Entity
@Table(name = "parametros")
public class Parametros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametros")
    private Long id;

    @NotNull(message = "Este campo no puede estar vacio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sedes")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Sedes id_sedes;

    @NotNull(message = "Este campo no puede estar vacio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private User id_user;

    @NotNull(message = "Este campo no puede estar vacio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Rol id_rol;

    // Constructor from Centros

    // Getters and Setters from Centros

}
