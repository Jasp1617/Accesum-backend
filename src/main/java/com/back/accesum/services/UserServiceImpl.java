package com.back.accesum.services;


import com.back.accesum.modelo.User;
import com.back.accesum.modelo.dao.IUserDao;
import com.back.accesum.modelo.tbl_fichas;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
            return (List<User>) userDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) {
            return userDao.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) {
            return userDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public User save(User user) {
            return userDao.save(user);
	}

	@Override
	@Transactional
	public void delete(Long id) {
            userDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<tbl_fichas> findAlltbl_fichas() {
            return userDao.findAlltbl_fichas();
	}

    @Override
    public User findByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
