package com.back.accesum.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.back.accesum.modelo.entity.Parametros;
import com.back.accesum.modelo.entity.Rol;
import com.back.accesum.modelo.entity.Sedes;
import com.back.accesum.modelo.entity.User;

public interface IParametrosService {
    public List<Parametros> findAll();

    public Parametros findById(Long id);

    public Parametros save(Parametros Parametros);

    public void delete(Long id);

    public List<User> findAllUser();
    public List<Rol> findAllRols();
    public List<Sedes> findAllSedes();

    public Page<Parametros> findAll(Pageable pageable);

}
