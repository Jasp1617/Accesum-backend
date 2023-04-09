package com.back.accesum.services;

import java.util.List;

import com.back.accesum.modelo.Centros;
import com.back.accesum.modelo.tbl_coordinacions;
import com.back.accesum.modelo.dao.ICoordinacionsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CoordinacionsServiceImpl implements ICoordinacionsService {
    @Autowired
    private ICoordinacionsDao coordinacionsDao;

    @Override
    public List<tbl_coordinacions> findAll() {
        return (List<tbl_coordinacions>) coordinacionsDao.findAll();
    }

    @Override
    public tbl_coordinacions findById(Long id) {
        return coordinacionsDao.findById(id).orElse(null);
    }

    @Override
    public tbl_coordinacions save(tbl_coordinacions tbl_coordinacions) {
        return coordinacionsDao.save(tbl_coordinacions);
    }

    @Override
    public void delete(Long id) {
        coordinacionsDao.deleteById(id);
    }

    @Override
    public List<Centros> findAllCentros() {
        return coordinacionsDao.findAllCentros();
    }


    @Override
    public Page<tbl_coordinacions> findAll(Pageable pageable) {
        return coordinacionsDao.findAll(pageable);
    }

    @Override
    public Page<tbl_coordinacions> findAll(SpringDataWebProperties.Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<tbl_coordinacions> findAll(PageRequest pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
