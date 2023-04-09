package com.back.accesum.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.back.accesum.modelo.Parametros;
import com.back.accesum.modelo.Rol;
import com.back.accesum.modelo.Sedes;
import com.back.accesum.modelo.User;

public interface IParametrosService {
    public List<Parametros> findAll();

    public Parametros findById(Long id);

    public Parametros save(Parametros Parametrostros);

    public void delete(Long id);

    public List<User> findAllUser();
    public List<Rol> findAllRols();
    public List<Sedes> findAllSedes();

    public Page<Parametros> findAll(Pageable pageable);

}
