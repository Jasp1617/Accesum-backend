package com.back.accesum.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.accesum.modelo.Centros;

// @author Jorge Silva Helmunt Urueta Jordan Hernandez Back-end equipo
@Repository
public interface CentrosRepository extends JpaRepository<Centros, Long> {
    
}
