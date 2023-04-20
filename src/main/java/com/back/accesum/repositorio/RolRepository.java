package com.back.accesum.repositorio;

import com.back.accesum.modelo.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @author Jorge Silva Helmunt Urueta Jordan Hernandez Back-end equipo
@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    
}
