package com.back.accesum.services;

import com.back.accesum.modelo.entity.Rol;
import com.back.accesum.modelo.entity.User;
import com.back.accesum.modelo.entity.tbl_fichas;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface IUserService {
        public User findByUsername(String username);

	public List<User> findAll();
	
	public Page<User> findAll(Pageable pageable);
	
	public User findById(Long id);
	
	public User save(User user);
	
	public void delete(Long id);
	
	public List<tbl_fichas> findAlltbl_fichas();

	public List<Rol> findAllrRols();
        
        

}
