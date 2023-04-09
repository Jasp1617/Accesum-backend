package com.back.accesum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.back.accesum.modelo.Parametros;
import com.back.accesum.modelo.Rol;
import com.back.accesum.modelo.Sedes;
import com.back.accesum.modelo.User;
import com.back.accesum.modelo.dao.IParametrosDao;;

@Service
public class ParametrosServiceImpl implements IParametrosService {
    @Autowired
    private IParametrosDao parametrosDao;

    @Override
    public List<Parametros> findAll() {
        return (List<Parametros>) parametrosDao.findAll();
    }

    @Override
    public Parametros findById(Long id) {
        return parametrosDao.findById(id).orElse(null);
    }

    @Override
    public Parametros save(Parametros Parametros) {
        return parametrosDao.save(Parametros);
    }

    @Override
    public void delete(Long id) {
        parametrosDao.deleteById(id);
    }

    @Override
    public List<User> findAllUser() {
        return parametrosDao.findAllUsers();
    }

    @Override
    public List<Rol> findAllRols() {
        return parametrosDao.findAllRols();
    }

    @Override
    public List<Sedes> findAllSedes() {
        return parametrosDao.findAllSedes();
    }

    @Override
    public Page<Parametros> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
