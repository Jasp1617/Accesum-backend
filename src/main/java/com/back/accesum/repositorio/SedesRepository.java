package com.back.accesum.repositorio;

import com.back.accesum.modelo.entity.Centros;
import com.back.accesum.modelo.entity.Sedes;
import com.back.accesum.modelo.entity.tbl_coordinacions;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// @author Jorge Silva Helmunt Urueta Jordan Hernandez Back-end equipo

@Repository
public interface SedesRepository extends JpaRepository<Sedes, Long>{
        @Query("from Centros")
	public List<Centros> findAllCentros();
        @Query("from tbl_coordinacions")
	public List<tbl_coordinacions> findAllCoordinacions();
}
