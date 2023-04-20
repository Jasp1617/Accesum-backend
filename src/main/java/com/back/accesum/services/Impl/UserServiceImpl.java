package com.back.accesum.services.Impl;

import com.back.accesum.modelo.entity.User;
import com.back.accesum.services.IUserService;
import com.back.accesum.modelo.entity.tbl_fichas;
import com.back.accesum.repositorio.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

	private final UserRepository userRepo;

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) {
		return userRepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) {
		return userRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public User save(User user) {
		return userRepo.save(user);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		userRepo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<tbl_fichas> findAlltbl_fichas() {
		return userRepo.findAlltbl_fichas();
	}

	@Override
	public User findByUsername(String username) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
