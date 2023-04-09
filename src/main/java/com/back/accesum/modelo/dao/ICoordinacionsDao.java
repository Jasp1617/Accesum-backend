package com.back.accesum.modelo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.back.accesum.modelo.Centros;
import com.back.accesum.modelo.tbl_coordinacions;

public interface ICoordinacionsDao extends JpaRepository<tbl_coordinacions,Long> {
    @Query("from Centros")
	public List<Centros> findAllCentros();
}
