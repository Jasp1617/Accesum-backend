package com.back.accesum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.back.accesum.modelo.Centros;
import com.back.accesum.modelo.regionales;
import com.back.accesum.modelo.dao.ICentrosDao;

@Service
public class CentrosServicesImpl implements ICentrosService{
    @Autowired
    private ICentrosDao centrosDao;

    @Override
    public List<Centros> findAll() {
        return (List<Centros>) centrosDao.findAll();
    }

    @Override
    public Centros findById(Long id) {
        return centrosDao.findById(id).orElse(null);
    }

    @Override
    public Centros save(Centros Centros) {
        return centrosDao.save(Centros);
    }

    @Override
    public void delete(Long id) {
        centrosDao.deleteById(id);
    }

    @Override
    public List<regionales> findAllRegionales() {
        return centrosDao.findAllRegionales();
    }


    @Override
    public Page<Centros> findAll(Pageable pageable) {
        return centrosDao.findAll(pageable);
    }

    @Override
    public Page<Centros> findAll(SpringDataWebProperties.Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<Centros> findAll(PageRequest pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
