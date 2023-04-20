package com.back.accesum.repositorio;

import com.back.accesum.modelo.entity.Parametros;
import com.back.accesum.modelo.entity.Rol;
import com.back.accesum.modelo.entity.Sedes;
import com.back.accesum.modelo.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParametrosRepository extends JpaRepository<Parametros, Long> {
        @Query("from Sedes")
	public List<Sedes> findAllSedes();
        @Query("from Rol")
	public List<Rol> findAllRols();
        @Query("from User")
	public List<User> findAllUsers();
}
