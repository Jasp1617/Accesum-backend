package com.back.accesum.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.accesum.modelo.entity.Centros;
import com.back.accesum.modelo.entity.regionales;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

// @author Jorge Silva Helmunt Urueta Jordan Hernandez Back-end equipo
@Repository
public interface CentrosRepository extends JpaRepository<Centros, Long> {
        @Query("from regionales")
	public List<regionales> findAllRegionales();
}
