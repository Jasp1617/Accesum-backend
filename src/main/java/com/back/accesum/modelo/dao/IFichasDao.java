package com.back.accesum.modelo.dao;

import com.back.accesum.modelo.tbl_coordinacions;
import com.back.accesum.modelo.tbl_fichas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IFichasDao extends JpaRepository<tbl_fichas, Long>{
    @Query("from tbl_coordinacions")
	public List<tbl_coordinacions> findAlltbl_coordinacions();
}
