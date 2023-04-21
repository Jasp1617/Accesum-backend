package com.back.accesum.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.accesum.modelo.entity.Rol;
import com.back.accesum.modelo.entity.User;
import com.back.accesum.modelo.entity.tbl_fichas;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long>{
    @Query("from tbl_fichas")
	public List<tbl_fichas> findAlltbl_fichas();

	@Query("from Rol")
	public List<Rol> findAllrols();
}

