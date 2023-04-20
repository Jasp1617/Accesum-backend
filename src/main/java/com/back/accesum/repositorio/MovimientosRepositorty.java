package com.back.accesum.repositorio;

import com.back.accesum.modelo.entity.Movimientos;
import com.back.accesum.modelo.entity.Sedes;
import com.back.accesum.modelo.entity.User;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MovimientosRepositorty extends JpaRepository<Movimientos, Integer>{
        @Query("from Sedes")
	public List<Sedes> findAllSedes();
        @Query("from User")
	public List<User> findAllUsers();
}
