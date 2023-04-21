package com.back.accesum.modelo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name = "movimientos")
public class Movimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mov")
    private Integer id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_user", referencedColumnName = "user_id")
    private User id_user;
    
    @CreationTimestamp
    private LocalDate Fecha;

    @CreationTimestamp
    private LocalTime Hora_entrada;
    
    @CreationTimestamp
    private LocalTime Hora_salida;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sede_id", referencedColumnName = "id_sedes")
    private Sedes id_sedes;
    




}
