package com.back.accesum.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.back.accesum.modelo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
