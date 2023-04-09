package com.back.accesum.modelo.dao;

import com.back.accesum.modelo.User;
import com.back.accesum.modelo.tbl_fichas;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface IUserDao extends JpaRepository<User, Long>{

	@Query("from tbl_fichas")
	public List<tbl_fichas> findAlltbl_fichas();
        
}
