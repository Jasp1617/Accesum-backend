package com.back.accesum.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.accesum.modelo.tbl_fichas;

// @author Jorge Silva Helmunt Urueta Jordan Hernandez Back-end equipo
@Repository
public interface FichasRepository extends JpaRepository<tbl_fichas, Long>{

}
