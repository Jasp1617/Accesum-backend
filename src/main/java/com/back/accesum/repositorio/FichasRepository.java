package com.back.accesum.repositorio;

import com.back.accesum.modelo.entity.tbl_coordinacions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.accesum.modelo.entity.tbl_fichas;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

// @author Jorge Silva Helmunt Urueta Jordan Hernandez Back-end equipo
@Repository
public interface FichasRepository extends JpaRepository<tbl_fichas, Long>{
    @Query("from tbl_coordinacions")
	public List<tbl_coordinacions> findAlltbl_coordinacions();
}
