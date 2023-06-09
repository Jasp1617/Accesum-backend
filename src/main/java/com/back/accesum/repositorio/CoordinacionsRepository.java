package com.back.accesum.repositorio;

import com.back.accesum.modelo.entity.Centros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.accesum.modelo.entity.tbl_coordinacions;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


// @author Jorge Silva Helmunt Urueta Jordan Hernandez Back-end equipo
@Repository
public interface CoordinacionsRepository extends JpaRepository<tbl_coordinacions, Long>{
        @Query("from Centros")
	public List<Centros> findAllCentros();
}
