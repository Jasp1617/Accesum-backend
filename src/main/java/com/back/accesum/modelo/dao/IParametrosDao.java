package com.back.accesum.modelo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.back.accesum.modelo.Parametros;
import com.back.accesum.modelo.Rol;
import com.back.accesum.modelo.Sedes;
import com.back.accesum.modelo.User;

public interface IParametrosDao extends JpaRepository<Parametros, Long> {
    @Query("from Sedes")
	public List<Sedes> findAllSedes();
    @Query("from Rol")
	public List<Rol> findAllRols();
    @Query("from User")
	public List<User> findAllUsers();
}
