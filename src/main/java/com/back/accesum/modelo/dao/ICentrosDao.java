package com.back.accesum.modelo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.back.accesum.modelo.Centros;
import com.back.accesum.modelo.regionales;

public interface ICentrosDao extends JpaRepository<Centros, Long> {
    @Query("from regionales")
	public List<regionales> findAllRegionales();
}
